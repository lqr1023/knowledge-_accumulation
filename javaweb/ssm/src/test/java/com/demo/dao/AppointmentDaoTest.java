package com.demo.dao;

import com.demo.BaseTest;
import com.demo.entity.Appointment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:
 * @Description:
 * @Data:Created in 11:12 2018/9/17
 */
public class AppointmentDaoTest extends BaseTest {

    @Autowired
    private AppointmentDao appointmentDao;

    @Test
    public void testInsertAppointment(){
        long bookId = 1000;
        long studentId = 12345678910L;
        int insert = appointmentDao.insertAppointment(bookId,studentId);
        System.out.println("insert=" + insert);
    }

    @Test
    public void testQueryByKeyWithBook(){
        long bookId = 1000;
        long studentId = 12345678910L;
        Appointment appointment = appointmentDao.queryByKeyWithBook(bookId,studentId);
        System.out.println(appointment.toString());
        System.out.println(appointment.getBook().toString());
    }
}
