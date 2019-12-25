package org.forbes.comm.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author lzw
 * @date 2019/12/25 15:35
 */
@ApiModel(description = "查询商家提现信息返回集合")
@Data
public class ShopCashVo implements Serializable{

    private static final long serialVersionUID = -5024986047024501661L;

    /**
     * 版本
     * Table:     f_shop_cash
     * Column:    version
     * Nullable:  true
     */
    @ApiModelProperty(value="版本")
    private Long version;

    /**
     * 账户
     * Table:     f_shop_cash
     * Column:    account
     * Nullable:  true
     */
    @ApiModelProperty(value="账户")
    private String account;

    /**
     * 金额数量
     * Table:     f_shop_cash
     * Column:    amount
     * Nullable:  true
     */
    @ApiModelProperty(value="金额数量")
    private BigDecimal amount;

    /**
     * 收款银行
     * Table:     f_shop_cash
     * Column:    version
     * Nullable:  true
     */
    @ApiModelProperty(value="收款银行")
    private String bank;

    /**
     * 状态0待审核1审核失败2审核成功
     * Table:     f_shop_cash
     * Column:    status
     * Nullable:  true
     */
    @ApiModelProperty(value="状态0待审核1审核失败2审核成功")
    private String status;

    /**
     * 商家id
     * Table:     f_shop_cash
     * Column:    business_id
     * Nullable:  true
     */
    @ApiModelProperty(value="商家id")
    private Long businessId;

    /**
     * Table:     f_shop
     * Column:    name
     * Nullable:  true
     */
    @ApiModelProperty(value="商家名称")
    private String name;
}
