package com.demo.dao;

import com.demo.BaseTest;
import com.demo.entity.Book;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author:
 * @Description:
 * @Data:Created in 10:42 2018/9/17
 */
public class BookDaoTest extends BaseTest {
    @Autowired
    private BookDao bookDao;

    @Test
    public void testQueryById(){
        long bookId = 1000;
        Book book = bookDao.queryById(bookId);
        System.out.println(book.toString());
    }
    @Test
    public void testQueryAll(){
        List<Book> books = bookDao.queryAll(0,4);
        for (Book book : books){
            System.out.println(book.toString());
        }
    }
    @Test
    public void testReduceNumber(){
        long bookId = 1000;
        int update = bookDao.reduceNumber(bookId);
        System.out.println("update=" + update);
    }
}
