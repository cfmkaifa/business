package org.forbes.comm.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "商家预存款分页查询返回对象")
@Data
public class ShopDepositVo implements Serializable{

    private static final long serialVersionUID = 3268487816737583635L;

    /**
     * 版本
     * Table:     f_shop_attach
     * Column:    version
     * Nullable:  true
     */
    @ApiModelProperty(value = "版本",example = "0")
    private Long version;

    /**
     * 余额
     * Table:     f_shop_attach
     * Column:    balance
     * Nullable:  true
     */
    @ApiModelProperty(value = "余额",example = "0")
    private BigDecimal balance;

    /**
     * 收入金额
     * Table:     f_shop_attach
     * Column:    credit
     * Nullable:  true
     */
    @ApiModelProperty(value = "收入金额",example = "0")
    private BigDecimal credit;

    /**
     * 支出金额
     * Table:     f_shop_attach
     * Column:    debit
     * Nullable:  true
     */
    @ApiModelProperty(value = "支出金额",example = "0")
    private BigDecimal debit;

    /**
     * 备注
     * Table:     f_shop_attach
     * Column:    memo
     * Nullable:  true
     */
    @ApiModelProperty(value = "备注")
    private String memo;

    /**
     * 类型
     * Table:     f_shop_attach
     * Column:    type
     * Nullable:  true
     */
    @ApiModelProperty(value = "类型")
    private String type;

    /**
     * 商家id
     * Table:     f_shop_attach
     * Column:    business_id
     * Nullable:  true
     */
    @ApiModelProperty(value = "商家id",example = "0")
    private Long shopId;
}
