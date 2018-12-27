### 关于颜色转换
工作中遇到了将ps过后的图片上传到网页上展示的问题，经过ps处理过的图片格式存储时颜色格式有时为CMYK，展示到界面上颜色失真，在网上找了各种转换方法，很多种方法经过尝试后发现都会有一部分颜色损失，最终选定了以下转换方式，目前测试阶段效果还不错。
参考文章：https://stackoverflow.com/questions/3123574/how-to-convert-from-cmyk-to-rgb-in-java-correctly   
```
public class JpegReader {

    public static final int COLOR_TYPE_RGB = 1;
    public static final int COLOR_TYPE_CMYK = 2;
    public static final int COLOR_TYPE_YCCK = 3;

    private int colorType = COLOR_TYPE_RGB;
    private boolean hasAdobeMarker = false;

    public BufferedImage readImage(File file) throws IOException, ImageReadException {
        hasAdobeMarker = false;
        ImageInputStream stream = ImageIO.createImageInputStream(file);
        Iterator<ImageReader> iter = ImageIO.getImageReaders(stream);
        //原文这里通过捕获异常的方式判定需不需要转颜色，为了测试删去了，参考原文逻辑补充...
        while (iter.hasNext()) {
            ImageReader reader = iter.next();
            reader.setInput(stream);
            BufferedImage image;
            ICC_Profile profile = null;
            colorType = COLOR_TYPE_CMYK;
            try {
                checkAdobeMarker(file);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            try {
                profile = Sanselan.getICCProfile(file);
            } catch (org.apache.sanselan.ImageReadException e1) {
                e1.printStackTrace();
            }
            WritableRaster raster = (WritableRaster) reader.readRaster(0, null);
            if (colorType == COLOR_TYPE_YCCK)
                convertYcckToCmyk(raster);
            if (hasAdobeMarker)
                convertInvertedColors(raster);
            image = convertCmykToRgb(raster, profile);
            return image;
        }

        return null;
    }

    public void checkAdobeMarker(File file) throws Exception {
        JpegImageParser parser = new JpegImageParser();
        ByteSource byteSource = new ByteSourceFile(file);
        @SuppressWarnings("rawtypes")
        ArrayList segments = parser.readSegments(byteSource, new int[] { 0xffee }, true);
        if (segments != null && segments.size() >= 1) {
            UnknownSegment app14Segment = (UnknownSegment) segments.get(0);
            byte[] data = app14Segment.bytes;
            if (data.length >= 12 && data[0] == 'A' && data[1] == 'd' && data[2] == 'o' && data[3] == 'b' && data[4] == 'e')
            {
                hasAdobeMarker = true;
                int transform = app14Segment.bytes[11] & 0xff;
                if (transform == 2)
                    colorType = COLOR_TYPE_YCCK;
            }
        }
    }

    public static void convertYcckToCmyk(WritableRaster raster) {
        int height = raster.getHeight();
        int width = raster.getWidth();
        int stride = width * 4;
        int[] pixelRow = new int[stride];
        for (int h = 0; h < height; h++) {
            raster.getPixels(0, h, width, 1, pixelRow);

            for (int x = 0; x < stride; x += 4) {
                int y = pixelRow[x];
                int cb = pixelRow[x + 1];
                int cr = pixelRow[x + 2];

                int c = (int) (y + 1.402 * cr - 178.956);
                int m = (int) (y - 0.34414 * cb - 0.71414 * cr + 135.95984);
                y = (int) (y + 1.772 * cb - 226.316);

                if (c < 0) c = 0; else if (c > 255) c = 255;
                if (m < 0) m = 0; else if (m > 255) m = 255;
                if (y < 0) y = 0; else if (y > 255) y = 255;

                pixelRow[x] = 255 - c;
                pixelRow[x + 1] = 255 - m;
                pixelRow[x + 2] = 255 - y;
            }

            raster.setPixels(0, h, width, 1, pixelRow);
        }
    }

    public static void convertInvertedColors(WritableRaster raster) {
        int height = raster.getHeight();
        int width = raster.getWidth();
        int stride = width * 4;
        int[] pixelRow = new int[stride];
        for (int h = 0; h < height; h++) {
            raster.getPixels(0, h, width, 1, pixelRow);
            for (int x = 0; x < stride; x++)
                pixelRow[x] = 255 - pixelRow[x];
            raster.setPixels(0, h, width, 1, pixelRow);
        }
    }

    public static BufferedImage convertCmykToRgb(Raster cmykRaster, ICC_Profile cmykProfile) throws IOException {
        if (cmykProfile == null)
        //这里上传了默认处理的.icc文件，该文件位于C:/Windows/System32/spool/drivers/color/JapanColor2001Coated.icc
            cmykProfile = ICC_Profile.getInstance(JpegReader.class.getResourceAsStream("/JapanColor2001Coated.icc"));
        if (cmykProfile.getProfileClass() != ICC_Profile.CLASS_DISPLAY) {
            byte[] profileData = cmykProfile.getData();

            if (profileData[ICC_Profile.icHdrRenderingIntent] == ICC_Profile.icPerceptual) {
                intToBigEndian(ICC_Profile.icSigDisplayClass, profileData, ICC_Profile.icHdrDeviceClass); // Header is first

                cmykProfile = ICC_Profile.getInstance(profileData);
            }
        }

        ICC_ColorSpace cmykCS = new ICC_ColorSpace(cmykProfile);
        BufferedImage rgbImage = new BufferedImage(cmykRaster.getWidth(), cmykRaster.getHeight(), BufferedImage.TYPE_INT_RGB);
        WritableRaster rgbRaster = rgbImage.getRaster();
        ColorSpace rgbCS = rgbImage.getColorModel().getColorSpace();
        ColorConvertOp cmykToRgb = new ColorConvertOp(cmykCS, rgbCS, null);
        cmykToRgb.filter(cmykRaster, rgbRaster);
        return rgbImage;
    }
    static void intToBigEndian(int value, byte[] array, int index) {
        array[index]   = (byte) (value >> 24);
        array[index+1] = (byte) (value >> 16);
        array[index+2] = (byte) (value >>  8);
        array[index+3] = (byte) (value);
    }

    public static void main(String[] args) {
        JpegReader jpegReader = new JpegReader();
        try{
            BufferedImage bufferedImage = jpegReader.readImage(new File("D:/report_gui/Resources/imgs/e1e483e4-459e-4e7b-a517-fb886e105add/beijing.jpg"));
            File file1 = new File("D:/report_gui/Resources/imgs/e1e483e4-459e-4e7b-a517-fb886e105add/beijing_rgb.jpg");
            ImageIO.write(bufferedImage, "jpg" , file1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
```
