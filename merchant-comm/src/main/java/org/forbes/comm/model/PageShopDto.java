package org.forbes.comm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author lzw
 * @date 2019/12/11 11:30
 */
@Data
@ApiModel(description="商家")
public class PageShopDto implements Serializable {

    private static final long serialVersionUID = 4407786734366553691L;

    /**
     * 状态
     * Table:     f_sys_user
     * Column:    status
     * Nullable:  false
     */
    @ApiModelProperty("用户状态")
    @NotEmpty(message="用户状态为空")
    private String status;

    /**
     * 角色ID
     * Table:     f_sys_user_role
     * Column:    role_id
     * Nullable:  true
     */
    @ApiModelProperty(value = "角色ID",example = "0")
    private Long roleId;

    /**
     * 公司名称
     * Table:     f_sys_role
     * Column:    role_name
     * Nullable:  true
     */
    @ApiModelProperty(value = "商家名称")
    private String name;

    /**
     * 登录账号
     * Table:     f_sys_user
     * Column:    username
     * Nullable:  false
     */
    @ApiModelProperty("用户名")
    @NotEmpty(message="用户名为空")
    private String username;

}
