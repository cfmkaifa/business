package org.forbes.comm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lzw
 * @date 2019/12/25 15:40
 */
@Data
@ApiModel(description = "商家提现分页传值")
public class ShopCashDto implements Serializable {

    private static final long serialVersionUID = 7768483297990641366L;

    /**
     * Table:     f_shop
     * Column:    name
     * Nullable:  true
     */
    @ApiModelProperty(value="商家名称")
    private String name;

    /**
     * 状态0待审核1审核失败2审核成功
     * Table:     f_shop_cash
     * Column:    status
     * Nullable:  true
     */
    @ApiModelProperty(value="状态0待审核1审核失败2审核成功")
    private String status;
}
