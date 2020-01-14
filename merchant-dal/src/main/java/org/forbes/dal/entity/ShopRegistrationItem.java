package org.forbes.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 商家注册项实体类
 * @author frunk
 */
@Data
@ApiModel(description="商家注册项")
@EqualsAndHashCode(callSuper = false)
@TableName("f_shop_registration_item")
public class ShopRegistrationItem extends BaseEntity{

    private static final long serialVersionUID = -1525575195615550956L;

    /**
     * 名称
     * Table:     f_shop_registration_item
     * Column:    name
     * Nullable:  true
     */
    @ApiModelProperty(value = "名称",required = true)
    private String name;

    /**
     * 名称
     * Table:     f_shop_registration_item
     * Column:    type
     * Nullable:  true
     */
    @ApiModelProperty(value = "类型",required = true)
    private String type;

    /**
     * 名称
     * Table:     f_shop_registration_item
     * Column:    is_required
     * Nullable:  true
     */
    @ApiModelProperty(value = "是否必填")
    private String isRequired;

    /**
     * 名称
     * Table:     f_shop_registration_item
     * Column:    is_enable
     * Nullable:  true
     */
    @ApiModelProperty(value = "是否启用",required = true)
    private String isEnable;

    /**
     * 名称
     * Table:     f_shop_registration_item
     * Column:    sort_no
     * Nullable:  true
     */
    @ApiModelProperty(value = "排序",required = true,example = "0")
    private Integer sortNo;



}
