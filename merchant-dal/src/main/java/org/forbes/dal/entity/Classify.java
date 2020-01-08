package org.forbes.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.forbes.comm.constant.SaveValid;

import javax.validation.constraints.NotEmpty;

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
     * 分类编码
     * Table:     f_shop_type
     * Column:    code
     * Nullable:  true
     */
    @ApiModelProperty(value = "分类编码")
    private String code;
}
