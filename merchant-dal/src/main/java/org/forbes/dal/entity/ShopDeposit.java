package org.forbes.dal.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.forbes.comm.constant.UpdateValid;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Table: f_shop_account
 */
@Data
@ApiModel(description="商家预存款")
@EqualsAndHashCode(callSuper = false)
@TableName("f_shop_deposit")
public class ShopDeposit extends BaseEntity{

    private static final long serialVersionUID = -3642135737982342782L;

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
    @ApiModelProperty(value = "商家id",example = "0",required = true)
    private Long shopId;

    /**
     * Table:     f_shop
     * Column:    name
     * Nullable:  true
     */
    @ApiModelProperty(value="商家名称",required = true)
    private String name;

}
