package org.forbes.comm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
@ApiModel(description = "商家注册项")
public class RegistrationItemPageDto implements Serializable{

    private static final long serialVersionUID = -1485740247391960216L;

    /**
     * 名称
     * Table:     f_shop_registration_item
     * Column:    name
     * Nullable:  true
     */
    @ApiModelProperty(value = "名称",required = true)
    private String name;
}
