package com.demo.dao;

import com.demo.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:
 * @Description:
 * @Data:Created in 18:06 2018/9/14
 */
public interface BookDao {
    /*
    * 一般的命名方式 查询get
    *  Service/DAO 层方法命名规约
    * 1） 获取单个对象的方法用get 做前缀。
    * 2） 获取多个对象的方法用list 做前缀。
    * 3） 获取统计值的方法用count 做前缀。
    * 4） 插入的方法用save （推荐）或insert做前缀。
    * 5） 删除的方法用remove （推荐）或delete 做前缀。
    * 6） 修改的方法用update 做前缀。
    */
    /**
     * 通过ID查询单本图书
     *
     * @param id
     * @return
     */
    Book queryById(long id);

    /**
     * 查询所有图书
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return
     */
    List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 减少馆藏数量
     *
     * @param bookId
     * @return 如果影响行数等于>1，表示更新的记录行数
     */
    int reduceNumber(long bookId);

}
