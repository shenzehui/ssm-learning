package com.szh.ioc.service.impl;

import com.szh.ioc.service.ProductService;

/**
 * @Author szh
 * @Date 2022/7/29 12:22
 * @PackageName:com.szh.ioc.service.impl
 * @ClassName: ProductServiceImpl
 * @Description: TODO
 * @Version 1.0
 */
public class ProductServiceImpl implements ProductService {
    @Override
    public void listProduct() {
        System.out.println("查询全部商品信息");
    }
}
