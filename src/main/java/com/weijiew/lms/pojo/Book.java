package com.weijiew.lms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @ClassName Book
 * @Author jie wei
 * @date 2020.11.15 23:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer BID; // 书籍 id
    private String BNO; // 书号
    private String BNAME; // 书名
    private String BAUTHOR; // 书作者
    private String BPUB;  // 书出版社
    private Double BPRICE; // 书价格
}
