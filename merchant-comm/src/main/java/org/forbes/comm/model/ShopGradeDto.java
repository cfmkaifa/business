package org.forbes.comm.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lzw
 * @date 2019/12/23 15:31
 */
@Data
@ApiModel(description = "商家等级传值")
public class ShopGradeDto implements Serializable{

    private static final long serialVersionUID = 7291476721403403596L;

    /**
     * 等级名字
     * Table:     f_shop_grade
     * Column:    name
     * Nullable:  true
     */
    private String name;

}
