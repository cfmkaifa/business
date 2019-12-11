package org.forbes.comm.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author lzw
 * @date 2019/12/11 11:50
 */
@ApiModel(description = "查询商家信息返回集合")
@Data
public class ShopUserVo implements Serializable {

    private static final long serialVersionUID = 8111234895089418202L;

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
    @ApiModelProperty(value = "公司名称")
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
