package com.lsxp.pojo;

import com.lsxp.annotation.Updatable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;

    @Updatable
    private String name;

    @Updatable
    private int age;

    @Updatable
    private String position;
}
