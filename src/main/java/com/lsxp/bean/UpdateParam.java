package com.lsxp.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateParam {
    private Map<String,String> columns;
    private Integer[] ids;
}
