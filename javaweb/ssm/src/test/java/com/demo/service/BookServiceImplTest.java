package com.demo.service;

import com.demo.BaseTest;
import com.demo.dto.AppointExecution;
import com.demo.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:
 * @Description:
 * @Data:Created in 16:06 2018/9/17
 */
public class BookServiceImplTest extends BaseTest {

    @Autowired
    private BookService bookService;

   @Test
    public void testGetById(){
        long bookId = 1003;
        System.out.println(bookService.getById(bookId).toString());
    }
    @Test
    public void testGetList(){

        for(Book book:bookService.getList()){
            System.out.println(book.toString());
        }
    }
}
