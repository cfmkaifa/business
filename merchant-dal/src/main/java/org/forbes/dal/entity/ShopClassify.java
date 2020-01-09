package org.forbes.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * Table: f_shop_classify
 */
@Data
@ApiModel(description = "商家经营分类中间表")
@EqualsAndHashCode(callSuper = false)
@TableName("f_shop_classify")
public class ShopClassify extends BaseEntity {

    private static final long serialVersionUID = -3312491326708266439L;

    /**
     * 商家id
     * Table:     f_shop_classify
     * Column:    is_enabled
     * Nullable:  true
     */
    @ApiModelProperty(value = "商家id", required = true)
    @NotNull(message = "商家id为空")
    private Long shopId;

    /**
     * 经营分类id
     * Table:     f_shop_classify
     * Column:    is_enabled
     * Nullable:  true
     */
    @ApiModelProperty(value = "经营分类id", required = true)
    @NotNull(message = "经营分类id为空")
    private Long classifyId;


    /**
     * 是否启用,0否1是
     * Table:     f_shop_classify
     * Column:    is_enabled
     * Nullable:  true
     */
    @ApiModelProperty(value = "是否启用,0否1是")
    private String isEnabled;
}
