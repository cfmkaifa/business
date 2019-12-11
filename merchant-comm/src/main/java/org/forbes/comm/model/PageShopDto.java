package org.forbes.comm.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author lzw
 * @date 2019/12/11 11:30
 */
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
     * 角色名称
     * Table:     f_sys_role
     * Column:    role_name
     * Nullable:  true
     */
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    /**
     * 公司名称
     * Table:     f_sys_role
     * Column:    role_name
     * Nullable:  true
     */
    @ApiModelProperty(value = "角色名称")
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
