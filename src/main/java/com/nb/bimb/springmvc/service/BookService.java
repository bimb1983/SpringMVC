package com.nb.bimb.springmvc.service;

import com.nb.bimb.springmvc.dao.IBookDao;
import com.nb.bimb.springmvc.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}: TODO
 *
 * @author :bimb
 * @create :2018-04-09 15:06
 **/
@Service
public class BookService implements IBookService{
    @Autowired
    IBookDao bookDao;

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }

    @Override
    public int add(Book entity) {
        return bookDao.add(entity);
    }

    @Override
    public int edit(Book entity) {
        return bookDao.edit(entity);
    }

    @Override
    public int delete(int id) {
        return bookDao.delete(id);
    }

    //多删除，重载
    @Override
    public int delete(int[] ids) {
        int rows=0;
        for (Integer id:ids) {  //遍历所有的编号
            rows+=delete(id);  //调用单删除功能，累计删除行数
        }
        return rows;
    }
}
