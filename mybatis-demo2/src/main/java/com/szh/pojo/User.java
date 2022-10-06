package com.szh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author szh
 * @Date 2022/7/27 13:45
 * @PackageName:com.szh.pojo
 * @ClassName: User
 * @Description: TODO
 * @Version 1.0
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String userName;
    private String userPwd;
    private String userRealname;
    private String userImg;

    private Detail detail;
}
