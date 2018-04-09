package com.nb.bimb.springmvc.dao;

import com.nb.bimb.springmvc.entities.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * ${DESCRIPTION}: TODO
 *
 * @author :bimb
 * @create :2018-04-09 14:33
 **/
public interface IBookDao {
    /**获得所有图书*/
    @Select("select id, title, typename, price, state from book")
    public List<Book> getAllBooks();
    /**获得单个图书对象通过编号*/
    @Select("select id, title, typename, price, state from book where id=#{id}")
    public Book getBookById(int id);
    /**添加*/
    @Insert("insert into Book(title, typename, price, state) values(#{title}, #{typename}, #{price}, #{state})")
    public int add(Book entity);
    /**编辑*/
    @Update("update Book set title=#{title}, typename=#{typename}, price=#{price}, state=#{state} where id=#{id}")
    public int edit(Book entity);
    /**删除*/
    @Delete("delete from Book where id=#{id}")
    public int delete(int id);
}
