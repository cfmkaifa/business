package org.forbes.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Table: f_shop_account
 */
@Data
@ApiModel(description="商家账号信息")
@EqualsAndHashCode(callSuper = false)
@TableName("f_shop_account")
public class ShopAccount extends BaseEntity {

	private static final long serialVersionUID = 5321472497068873621L;

	/**
     * 商家ID
     * Table:     f_shop_account
     * Column:    shop_id
     * Nullable:  true
     */
    private Long shopId;

    /**
     * 用户ID
     * Table:     f_shop_account
     * Column:    user_id
     * Nullable:  true
     */
    private Long userId;
    
    
    /**
     * 登录账号
     * Table:     f_sys_user
     * Column:    username
     * Nullable:  false
     */
    @ApiModelProperty(value = "登录账号")
    private String username;

    /**
     * 密码
     * Table:     f_sys_user
     * Column:    password
     * Nullable:  true
     */
    @ApiModelProperty(value = "密码")
    private String password;

    
    /**
     * md5密码盐
     */
	@JsonIgnore
    private String salt;
	
	
	@ApiModelProperty(value="电话")
    private String phone;

    /**
     * 头像
     * Table:     f_sys_user
     * Column:    avatar
     * Nullable:  true
     */
    @ApiModelProperty(value = "头像")
    private String avatar;


    /**
     * 姓名
     * Table:     f_sys_user
     * Column:    realname
     * Nullable:  true
     */
    @ApiModelProperty(value = "姓名",required = true)
    private String realname;
    
}