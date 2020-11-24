package com.weijiew.lms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @ClassName BR
 * @Author jie wei
 * @date 2020.11.15 23:20
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BR {
    private Integer BID;
    private String RNO;
    private String OUTDTE;
    private String INDTE;
}
