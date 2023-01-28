package com.example.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@TableName("tbl_book")
//@Setter
//@Getter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode
@Data
public class User {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
