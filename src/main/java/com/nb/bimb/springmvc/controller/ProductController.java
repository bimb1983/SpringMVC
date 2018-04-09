package com.nb.bimb.springmvc.controller;

import com.nb.bimb.springmvc.entities.Product;
import com.nb.bimb.springmvc.service.ProductService;
import com.nb.bimb.springmvc.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ${DESCRIPTION}: TODO
 *
 * @author :bimb
 * @create :2018-04-08 14:38
 **/
@Controller
@RequestMapping("/productcontroller")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductTypeService productTypeService;

    //展示与搜索action
    @RequestMapping
    public String index(Model model, String searchKey) {
        model.addAttribute("products", productService.getProductsByName(searchKey));
        model.addAttribute("searchKey", searchKey);
        return "product/index";
    }

    //删除，id为路径变量
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        productService.deleteProduct(id);
        return "redirect:/productcontroller";
    }

    //多删除，ids的值为多个id参数组成
    @RequestMapping("/deletes")
    public String deletes(@RequestParam("id")int[] ids){
        productService.deletesProduct(ids);
        return "redirect:/productcontroller";
    }

    // 新增，渲染出新增界面
    @RequestMapping("/add")
    public String add(Model model) {
        // 与form绑定的模型
        model.addAttribute("product", new Product());
        // 用于生成下拉列表
        model.addAttribute("productTypes", productTypeService.getAllProductTypes());
        return "product/add";
    }

    // 新增保存，如果新增成功转回列表页，如果失败回新增页，保持页面数据
    @RequestMapping("/addSave")
    public String addSave(Model model,Product product) {
        try {
            //根据类型的编号获得类型对象
            product.setProductType(productTypeService.getProductTypeById(product.getProductType().getId()));
            productService.addProduct(product);
            return "redirect:/productcontroller";
        } catch (Exception exp) {
            // 与form绑定的模型
            model.addAttribute("product", product);
            // 用于生成下拉列表
            model.addAttribute("productTypes", productTypeService.getAllProductTypes());
            //错误消息
            model.addAttribute("message", exp.getMessage());
            return "product/add";
        }
    }

    // 编辑，渲染出编辑界面，路径变量id是用户要编辑的产品编号
    @RequestMapping("/edit/{id}")
    public String edit(Model model,@PathVariable int id) {
        // 与form绑定的模型
        model.addAttribute("product", productService.getProductById(id));
        // 用于生成下拉列表
        model.addAttribute("productTypes", productTypeService.getAllProductTypes());
        return "product/edit";
    }

    // 编辑后保存，如果更新成功转回列表页，如果失败回编辑页，保持页面数据
    @RequestMapping("/editSave")
    public String editSave(Model model,Product product) {
        try {
            //根据类型的编号获得类型对象
            product.setProductType(productTypeService.getProductTypeById(product.getProductType().getId()));
            productService.updateProduct(product);
            return "redirect:/productcontroller";
        } catch (Exception exp) {
            // 与form绑定的模型
            model.addAttribute("product", product);
            // 用于生成下拉列表
            model.addAttribute("productTypes", productTypeService.getAllProductTypes());
            //错误消息
            model.addAttribute("message", exp.getMessage());
            return "product/edit";
        }
    }
}
