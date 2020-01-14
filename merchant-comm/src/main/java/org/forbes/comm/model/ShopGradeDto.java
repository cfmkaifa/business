package org.forbes.comm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author frunk
 * @date 2019/12/23 15:31
 */
@Data
@ApiModel(description = "商家等级传值")
public class ShopGradeDto implements Serializable{

    private static final long serialVersionUID = 7291476721403403596L;

    /**
     * 等级名称
     * Table:     f_shop_grade
     * Column:    grade_name
     * Nullable:  true
     */
    @ApiModelProperty(value = "等级名称")
    private String gradeName;



}
