package com.nb.bimb.springmvc.service;

import com.nb.bimb.springmvc.entities.ProductType;

import java.util.List;

/**
 * ${DESCRIPTION}: TODO
 *
 * @author :bimb
 * @create :2018-04-08 14:34
 **/
public interface ProductTypeService {
    /**
     * 根据产品类型编号获得产品类型对象
     */
    public ProductType getProductTypeById(int id);

    /**
     * 获得所有的产品类型
     */
    public List<ProductType> getAllProductTypes();
}
