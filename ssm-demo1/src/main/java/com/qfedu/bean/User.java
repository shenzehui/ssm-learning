package com.qfedu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author szh
 * @Date 2022/8/2 1:01
 * @PackageName:com.qfedu.bean
 * @ClassName: User
 * @Description: TODO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer userId;
    private String userName;
    private String userPwd;
    private String userRealname;
    private String userImg;
}
