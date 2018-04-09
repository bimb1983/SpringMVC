package com.nb.bimb.springmvc.service;

import com.nb.bimb.springmvc.entities.Product;

import java.util.List;

/**
 * ${DESCRIPTION}: TODO
 *
 * @author :bimb
 * @create :2018-04-08 14:36
 **/
public interface ProductService {
    /*
     * 获得所有的产品
     */
    List<Product> getAllProducts();

    /*
     * 获得产品通过编号
     */
    Product getProductById(int id);

    /*
     * 获得产品名称通过名称
     */
    List<Product> getProductsByName(String productName);

    /**
     * 新增产品对象
     */
    void addProduct(Product enttiy) throws Exception;

    /**
     * 更新产品对象
     */
    public void updateProduct(Product entity) throws Exception;

    /**
     * 删除产品对象
     */
    void deleteProduct(int id);

    /**
     * 多删除产品对象
     */
    void deletesProduct(int[] ids);
}
