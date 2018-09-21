package com.demo.service.impl;

import com.demo.dao.AppointmentDao;
import com.demo.dao.BookDao;
import com.demo.dto.AppointExecution;
import com.demo.entity.Appointment;
import com.demo.entity.Book;
import com.demo.enums.AppointStateEnum;
import com.demo.exception.AppointException;
import com.demo.exception.NoNumberException;
import com.demo.exception.RepeatAppointException;
import com.demo.service.BookService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

/**
 * @Author:
 * @Description:
 * @Data:Created in 15:10 2018/9/17
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private AppointmentDao appointmentDao;

    @Override
    public Book getById(long bookId) {
        return bookDao.queryById(bookId);
    }

    @Override
    public List<Book> getList() {
        return bookDao.queryAll(0,1000);
    }

    @Override
    @Transactional
    /**
     * 使用注解控制事务方法的优点： 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
     */
    public AppointExecution appoint(long bookId, long studentId) {
        try{
            int update = bookDao.reduceNumber(bookId);
            if (update <= 0 ){
                //在service层返回异常 由controller层处理这个异常结果返回给客户端 不能直接返回一个错误结果
                throw new NoNumberException("库存不足");
            }else {
                int insert = appointmentDao.insertAppointment(bookId, studentId);
                if (insert <= 0) {
                    throw new RepeatAppointException("重复预约");
                } else {//预约成功
                    Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
                    return new AppointExecution(bookId, AppointStateEnum.SUCCESS, appointment);
                }
            }
        }catch (NoNumberException e1){
            throw e1;
        }catch (RepeatAppointException e2){
            throw e2;
        }catch (Exception e){
            throw new AppointException("未知异常:" + e.getMessage());
        }
    }
}
