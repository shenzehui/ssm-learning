package com.qfedu.dao;

import com.qfedu.pojo.Detail;

/**
 * @Author szh
 * @Date 2022/7/27 13:48
 * @PackageName:com.qfedu.dao
 * @ClassName: DetailDao
 * @Description: TODO
 * @Version 1.0
 */
public interface DetailDao {
    int insertDetail(Detail detail);

    Detail queryDetailByUid(String uid);
}
