package org.forbes.dal.entity;

import lombok.Data;

/**
 * Table: f_shop_account
 */
@Data
public class ShopAccount extends BaseEntity {
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