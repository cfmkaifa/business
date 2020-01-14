package org.forbes.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author frunk
 * @date 2019/12/23 14:37
 */
@Data
@ApiModel(description="商家等级")
@EqualsAndHashCode(callSuper = false)
@TableName("f_shop_grade")
public class ShopGrade extends BaseEntity{

    private static final long serialVersionUID = 5916568212496208997L;

    /**
     * 等级名称
     * Table:     f_shop_grade
     * Column:    grade_name
     * Nullable:  true
     */
    @ApiModelProperty(value = "等级名称",required = true)
    @NotEmpty(message = "等级名称为空")
    private String gradeName;

    /**
     * 可发布商品数量
     * Table:     f_shop_grade
     * Column:    release_quantity
     * Nullable:  true
     */
    @ApiModelProperty(value = "可发布商品数量",example = "0")
    private Integer releaseQuantity;

    /**
     * 服务费
     * Table:     f_shop_grade
     * Column:    service_charge
     * Nullable:  true
     */
    @ApiModelProperty(value = "服务费",example = "0",required = true)
    @NotNull(message = "服务费不能为空")
    private BigDecimal serviceCharge;

    /**
     * 备注
     * Table:     f_shop_grade
     * Column:    remark
     * Nullable:  true
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 是否允许注册
     * Table:     f_shop_grade
     * Column:    is_registration
     * Nullable:  true
     */
    @ApiModelProperty(value = "是否允许注册,0否1是")
    private String isRegistration;
}
