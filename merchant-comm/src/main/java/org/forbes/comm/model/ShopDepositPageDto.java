package org.forbes.comm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description="商家提现传入条件")
public class ShopDepositPageDto implements Serializable{

    private static final long serialVersionUID = -5341677901574727382L;

    /**
     * Table:     f_shop
     * Column:    name
     * Nullable:  true
     */
    @ApiModelProperty("商家名称")
    private String name;

}
