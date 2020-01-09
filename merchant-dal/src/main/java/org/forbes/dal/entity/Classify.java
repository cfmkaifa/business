package org.forbes.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.forbes.comm.constant.SaveValid;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author lzw
 * @date 2019/12/23 14:43
 */
@Data
@ApiModel(description="商家分类")
@EqualsAndHashCode(callSuper = false)
@TableName("f_classify")
public class Classify extends BaseEntity{

    private static final long serialVersionUID = -7261905241413419735L;

    /**
     * 经营分类名称
     * Table:     f_shop_type
     * Column:    name
     * Nullable:  true
     */
    @ApiModelProperty(value = "经营分类名称",required = true)
    @NotEmpty(message = "经营分类名称为空",groups = SaveValid.class)
    private String classifyName;

    /**
     * 分类简介
     * Table:     f_shop_type
     * Column:    described
     * Nullable:  true
     */
    @ApiModelProperty(value = "分类简介")
    private String described;

    /**
     * 排序
     * Table:     f_shop_type
     * Column:    sort_no
     * Nullable:  true
     */
    @ApiModelProperty(value = "排序",required = true)
    private String sortNo;

    /**
     * 保证金
     * Table:     f_shop_type
     * Column:    bond
     * Nullable:  true
     */
    @ApiModelProperty(value = "保证金",required = true,example = "0")
    @NotNull(message = "保证金为空")
    private BigDecimal bond;
}
