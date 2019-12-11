package org.forbes.dal.entity;

import java.util.Date;
import lombok.Data;

/**
 * Table: f_shop_account
 */
@Data
public class ShopAccount extends BaseEntity {
    /**
     * 主键
     * Table:     f_shop_account
     * Column:    id
     * Nullable:  false
     */
    private Long id;

    /**
     * Table:     f_shop_account
     * Column:    create_by
     * Nullable:  true
     */
    private String createBy;

    /**
     * 创建时间
     * Table:     f_shop_account
     * Column:    create_time
     * Nullable:  true
     */
    private Date createTime;

    /**
     * 更新人
     * Table:     f_shop_account
     * Column:    update_by
     * Nullable:  true
     */
    private String updateBy;

    /**
     * 更新时间
     * Table:     f_shop_account
     * Column:    update_time
     * Nullable:  true
     */
    private Date updateTime;

    /**
     * 商家ID
     * Table:     f_shop_account
     * Column:    shop_id
     * Nullable:  true
     */
    private Long shopId;

    /**
     * 用户ID
     * Table:     f_shop_account
     * Column:    user_id
     * Nullable:  true
     */
    private Long userId;
}