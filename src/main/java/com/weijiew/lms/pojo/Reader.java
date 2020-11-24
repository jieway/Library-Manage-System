package com.weijiew.lms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @ClassName Reader
 * @Author jie wei
 * @date 2020.11.15 23:18
 */
@Data
@AllArgsConstructor // 无参构造
@NoArgsConstructor  // 有参构造
public class Reader {
    private Integer RNO;
    private String RNAME;
    private String password;
    private Integer superUser;
    private String RSEX;
    private String RTEL;
    private String RDEP;
}
