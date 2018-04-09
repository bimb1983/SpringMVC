package com.nb.bimb.springmvc.service;

import com.nb.bimb.springmvc.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}: TODO
 *
 * @author :bimb
 * @create :2018-04-09 15:05
 **/
public interface IBookService {
    /**获得所有图书*/
    public List<Book> getAllBooks();
    /**获得单个图书对象通过编号*/
    public Book getBookById(int id);
    /**添加*/
    public int add(Book entity);
    /**编辑*/
    public int edit(Book entity);
    /**删除*/
    public int delete(int id);
    /**多删除*/
    public int delete(int[] ids);
}
