package com.qfedu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

import javax.sql.DataSource;

/**
 * @Author szh
 * @Date 2022/7/27 23:43
 * @PackageName:com.qfedu.utils
 * @ClassName: DruidDataSourceFactory
 * @Description: TODO
 * @Version 1.0
 */
public class DruidDataSourceFactory extends PooledDataSourceFactory {

    public DruidDataSourceFactory() {
        this.dataSource = new DruidDataSource();
    }
}
