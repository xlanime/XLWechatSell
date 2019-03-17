package com.xlearn.sell.form;

import lombok.Data;

/**
 * Description:表单传递到后端的类目信息对象
 *
 * @author 轩辚
 * @date 2019/3/16 20:58
 */
@Data
public class CategoryForm {
    /** 类目ID */
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
