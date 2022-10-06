package com.szh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author szh
 * @Date 2022/7/27 20:45
 * @PackageName:com.szh.pojo
 * @ClassName: MemberSearchCondition
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class MemberSearchCondition {
    private String gender;
    private Integer minAge;
    private Integer maxAge;
    private String city;
}
