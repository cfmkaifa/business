package org.forbes.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author lzw
 * @date 2019/12/25 14:46
 */
@Data
@ApiModel(description="商家提现")
@EqualsAndHashCode(callSuper = false)
@TableName("f_shop_cash")
public class ShopCash extends BaseEntity{

    private static final long serialVersionUID = -2400837944613496314L;

    /**
     * 版本
     * Table:     f_shop_cash
     * Column:    version
     * Nullable:  true
     */
    private Long version;

    /**
     * 账户
     * Table:     f_shop_cash
     * Column:    account
     * Nullable:  true
     */
    private String account;

    /**
     * 金额数量
     * Table:     f_shop_cash
     * Column:    amount
     * Nullable:  true
     */
    private BigDecimal amount;

    /**
     * 收款银行
     * Table:     f_shop_cash
     * Column:    version
     * Nullable:  true
     */
    private String bank;

    /**
     * 状态0待审核1审核失败2审核成功
     * Table:     f_shop_cash
     * Column:    status
     * Nullable:  true
     */
    private String status;

    /**
     * 商家id
     * Table:     f_shop_cash
     * Column:    shop_id
     * Nullable:  true
     */
    private Long shopId;



}
