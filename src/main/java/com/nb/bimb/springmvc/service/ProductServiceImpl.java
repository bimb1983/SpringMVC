package com.nb.bimb.springmvc.service;

import com.nb.bimb.springmvc.entities.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}: TODO
 *
 * @author :bimb
 * @create :2018-04-08 14:37
 **/
@Service
public class ProductServiceImpl implements ProductService {
    private static List<Product> products;

    static {
        ProductTypeService productTypeService = new ProductTypeServiceImpl();
        products = new ArrayList<Product>();
        products.add(new Product(198, "Huwei P8", 4985.6, productTypeService.getProductTypeById(11)));
        products.add(new Product(298, "李宁运动鞋", 498.56, productTypeService.getProductTypeById(21)));
        products.add(new Product(398, "Spring MVC权威指南", 49.856, productTypeService.getProductTypeById(31)));
        products.add(new Product(498, "山东国光苹果", 4.9856, productTypeService.getProductTypeById(51)));
        products.add(new Product(598, "8开门超级大冰箱", 49856.1, productTypeService.getProductTypeById(41)));
    }

    /*
     * 获得所有的产品
     */
    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    /*
     * 获得产品通过编号
     */
    @Override
    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    /*
     * 获得产品名称通过名称
     */
    @Override
    public List<Product> getProductsByName(String productName) {
        if(productName==null||productName.equals("")){
            return getAllProducts();
        }
        List<Product> result = new ArrayList<Product>();
        for (Product product : products) {
            if (product.getName().contains(productName)) {
                result.add(product);
            }
        }
        return result;
    }

    /**
     * 新增
     * @throws Exception
     */
    @Override
    public void addProduct(Product entity) throws Exception {
        if(entity.getName()==null||entity.getName().equals("")){
            throw new Exception("产品名称必须填写");
        }
        if (products.size() > 0) {
            entity.setId(products.get(products.size() - 1).getId() + 1);
        } else {
            entity.setId(1);
        }
        products.add(entity);
    }

    /*
     * 更新
     */
    @Override
    public void updateProduct(Product entity) throws Exception
    {
        if(entity.getPrice()<0){
            throw new Exception("价格必须大于0");
        }
        Product source=getProductById(entity.getId());
        source.setName(entity.getName());
        source.setPrice(entity.getPrice());
        source.setProductType(entity.getProductType());
    }

    /**
     * 删除
     */
    @Override
    public void deleteProduct(int id){
        products.remove(getProductById(id));
    }

    /*
     * 多删除
     */
    @Override
    public void deletesProduct(int[] ids){
        for (int id : ids) {
            deleteProduct(id);
        }
    }
}
