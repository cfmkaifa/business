package org.forbes.comm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lzw
 * @date 2019/12/24 15:16
 */
@Data
@ApiModel(description = "商家等级传值")
public class ShopTypeDto implements Serializable {

    private static final long serialVersionUID = 3758252468533488606L;

    /**
     * 分类名字
     * Table:     f_shop_type
     * Column:    name
     * Nullable:  true
     */
    @ApiModelProperty(value = "分类名字",required = true)
    private String name;
}
