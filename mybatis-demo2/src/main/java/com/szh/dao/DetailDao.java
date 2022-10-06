package com.szh.dao;

import com.szh.pojo.Detail;

/**
 * @Author szh
 * @Date 2022/7/27 13:48
 * @PackageName:com.szh.dao
 * @ClassName: DetailDao
 * @Description: TODO
 * @Version 1.0
 */
public interface DetailDao {
    int insertDetail(Detail detail);

    Detail queryDetailByUid(String uid);
}
