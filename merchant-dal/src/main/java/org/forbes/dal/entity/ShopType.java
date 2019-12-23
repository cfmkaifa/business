package org.forbes.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lzw
 * @date 2019/12/23 14:43
 */
@Data
@ApiModel(description="商家分类")
@EqualsAndHashCode(callSuper = false)
@TableName("f_shop_type")
public class ShopType extends BaseEntity{

    private static final long serialVersionUID = -7261905241413419735L;

    /**
     * 商家ID
     * Table:     f_shop_type
     * Column:    shop_id
     * Nullable:  true
     */
    private Long shopId;

    /**
     * 分类名字
     * Table:     f_shop_type
     * Column:    name
     * Nullable:  true
     */
    private String name;

    /**
     * 分类简介
     * Table:     f_shop_type
     * Column:    describe
     * Nullable:  true
     */
    private String describe;

    /**
     * 分类编码
     * Table:     f_shop_type
     * Column:    code
     * Nullable:  true
     */
    private String code;
}
