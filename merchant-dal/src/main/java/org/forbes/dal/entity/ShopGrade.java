package org.forbes.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lzw
 * @date 2019/12/23 14:37
 */
@Data
@ApiModel(description="商家等级")
@EqualsAndHashCode(callSuper = false)
@TableName("f_shop_grade")
public class ShopGrade extends BaseEntity{

    private static final long serialVersionUID = 5916568212496208997L;

    /**
     * 商家ID
     * Table:     f_shop_grade
     * Column:    shop_id
     * Nullable:  true
     */
    private Long shopId;

    /**
     * 等级名字
     * Table:     f_shop_grade
     * Column:    name
     * Nullable:  true
     */
    private String name;

    /**
     * 级别0一级1二级2三级
     * Table:     f_shop_grade
     * Column:    grade
     * Nullable:  true
     */
    private String grade;
}