package com.nb.bimb.springmvc.controller;

import com.nb.bimb.springmvc.entities.Book;
import com.nb.bimb.springmvc.service.IBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

/**
 * ${DESCRIPTION}: TODO
 *
 * @author :bimb
 * @create :2018-04-09 15:07
 **/
@Controller
@RequestMapping("/Book")
public class BookController {
    @Resource
    IBookService bookService;

    @RequestMapping("/list")
    public String list(Model model){
        //获得所有的图书带到页面中
        model.addAttribute("books",bookService.getAllBooks());
        return "book/list";
    }

    @RequestMapping("/del/{id}")
    public String del(Model model, @PathVariable int id, RedirectAttributes flash) {
        //执行删除，如果影响行行数大于0,则成功
        if (bookService.delete(id) > 0) {
            flash.addFlashAttribute("msg","删除成功！");
        } else {
            flash.addFlashAttribute("msg","删除失败！");
        }
        //重定向
        return "redirect:/Book/list";
    }

    @RequestMapping("/dels")
    public String dels(Model model, @RequestParam(value = "id",required = false) int[] ids, RedirectAttributes flash) {
        //执行删除，如果影响行行数大于0,则成功
        int rows=bookService.delete(ids);
        if ( rows> 0) {
            flash.addFlashAttribute("msg","删除成功"+rows+"行！");
        } else {
            flash.addFlashAttribute("msg","删除失败！");
        }
        //重定向
        return "redirect:/Book/list";
    }

    //添加
    @RequestMapping("/add")
    public String add(Model model) {
        return "book/add";
    }

    //添加保存
    @RequestMapping("/addSave")
    public String add(Model model, Book book, RedirectAttributes flash) {
        //执行删除，如果影响行行数大于0,则成功
        if (bookService.add(book) > 0) {
            flash.addFlashAttribute("msg", "添加成功！");
            //重定向
            return "redirect:/Book/list";
        } else {
            flash.addFlashAttribute("msg", "添加失败！");
            flash.addFlashAttribute("", book);
            return "redirect:/Book/add";
        }
    }

    //编辑
    @RequestMapping("/edit")
    public String edit(Model model,int id) {
        //将要编辑的图书对象带入视图
        model.addAttribute("book",bookService.getBookById(id));
        return "book/edit";
    }

    //编辑保存
    @RequestMapping("/editSave")
    public String edit(Model model, Book book, RedirectAttributes flash) {
        //执行更新，如果影响行行数大于0,则成功
        if (bookService.edit(book) > 0) {
            flash.addFlashAttribute("msg","更新成功！");
            //重定向
            return "redirect:/Book/list";
        } else {
            flash.addFlashAttribute("msg","更新失败！");
            flash.addFlashAttribute("book",book);
            return "redirect:/Book/edit";
        }
    }
}
