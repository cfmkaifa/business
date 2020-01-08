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
@ApiModel(description = "经营分类分页传入参数")
public class ClassifyDto implements Serializable {

    private static final long serialVersionUID = 3758252468533488606L;

    /**
     * 经营分类名称
     * Table:     f_shop_type
     * Column:    name
     * Nullable:  true
     */
    @ApiModelProperty(value = "经营分类名称")
    private String classifyName;
}
