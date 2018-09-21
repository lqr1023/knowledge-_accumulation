package com.demo.controller;

import com.demo.dto.AppointExecution;
import com.demo.dto.Result;
import com.demo.entity.Book;
import com.demo.enums.AppointStateEnum;
import com.demo.exception.NoNumberException;
import com.demo.exception.RepeatAppointException;
import com.demo.service.BookService;
import org.apache.ibatis.jdbc.Null;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:
 * @Description:
 * @Data:Created in 16:29 2018/9/17
 */
@Controller
@RequestMapping("/book") //url:/模块/资源/{id}/细分 /seckill/list
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    private String list(Model model){
        List<Book> list = bookService.getList();
        model.addAttribute("list",list);
        return "list";//返回视图层
    }

    @RequestMapping(value = "/{bookId}/detail",method = RequestMethod.GET)
    private String detail(@PathVariable("bookId") Long bookId, Model model){

        if (bookId == null) {
            //redirect（重定向）：
            //是服务端根据逻辑,发送一个状态码,告诉浏览器重新去请求那个地址.所以地址栏显示的是新的URL.
            //转发是服务器行为，重定向是客户端行为。
            return "redirect:/book/list";
        }
        Book book = bookService.getById(bookId);
        if (book == null) {
            //forward（转发）：
            //是服务器请求资源,服务器直接访问目标地址的URL,把那个URL的响应内容读取过来,
            // 然后把这些内容再发给浏览器.
            // 浏览器根本不知道服务器发送的内容从哪里来的,因为这个跳转过程实在服务器实现的，
            // 并不是在客户端实现的所以客户端并不知道这个跳转动作，所以它的地址栏还是原来的地址.
            return "forward:/book/list";
        }
        model.addAttribute("book", book);
        return "detail";
    }

    //produces它的作用是指定返回值类型，不但可以设置返回值类型还可以设定返回值的字符编码；
    //还有一个属性与其对应，就是consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;
    @RequestMapping(value = "/{bookId}/appoint",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    @ResponseBody
    private Result<AppointExecution> appoint(@PathVariable("bookId")Long bookId, @RequestParam( value = "studentId")Long studentId){

        System.out.println("执行订阅方法");

        if (studentId == null || studentId.equals("")) {
            return new Result<>(false,"学号不能为空");
        }
        AppointExecution execution = null;
        try{
            execution = bookService.appoint(bookId,studentId);
        } catch (NoNumberException e1){
            execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
        } catch (RepeatAppointException e2){
            execution = new AppointExecution(bookId,AppointStateEnum.REPEAT_APPOINT);
        } catch (Exception e){
            execution = new AppointExecution(bookId,AppointStateEnum.INNER_ERROR);
        }
        return new Result<AppointExecution>(true,execution);
    }

}
