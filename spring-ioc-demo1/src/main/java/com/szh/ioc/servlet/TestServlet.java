package com.szh.ioc.servlet;

import com.szh.ioc.service.ProductService;

/**
 * @Author szh
 * @Date 2022/7/29 10:07
 * @PackageName:com.szh.ioc.servlet
 * @ClassName: TestServlet
 * @Description: TODO
 * @Version 1.0
 */
public class TestServlet {

    private ProductService productService;

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void doGet(){
        productService.listProduct();
    }

}
