package com.szh.ioc.service.impl;

import com.szh.ioc.service.ProductService;

/**
 * @Author szh
 * @Date 2022/7/29 12:26
 * @PackageName:com.szh.ioc.service.impl
 * @ClassName: ProductServiceImpl2
 * @Description: TODO
 * @Version 1.0
 */
public class ProductServiceImpl2 implements ProductService {
    @Override
    public void listProduct() {
        System.out.println("查询热销商品");
    }
}
