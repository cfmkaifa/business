package org.forbes.dal.entity;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Table: f_shop
 */
@Data
@ApiModel(description="商家信息")
@EqualsAndHashCode(callSuper = false)
@TableName("f_shop")
public class Shop extends BaseEntity {

	private static final long serialVersionUID = 1845356560770496019L;

	/**
     * Table:     f_shop
     * Column:    name
     * Nullable:  true
     */
	@ApiModelProperty(value="商家名称",required = true)
	@NotEmpty(message="商家名称为空")
    private String name;

    /**
     * Table:     f_shop
     * Column:    email
     * Nullable:  true
     */
	@ApiModelProperty(value="邮箱",required = true)
    private String email;

    /**
     * Table:     f_shop
     * Column:    phone
     * Nullable:  true
     */
	@ApiModelProperty(value="电话",required = true)
	@NotEmpty(message="电话为空")
    private String phone;

    /**
     * Table:     f_shop
     * Column:    fax
     * Nullable:  true
     */
	@ApiModelProperty(value="传真",required = true)
    private String fax;

    /**
     * 机构代码
     * Table:     f_shop
     * Column:    org_code
     * Nullable:  true
     */
	@ApiModelProperty(value="机构代码",required = true)
	@NotEmpty(message="机构代码代码为空")
    private String orgCode;

    /**
     * 法人
     * Table:     f_shop
     * Column:    legal_person
     * Nullable:  true
     */
	@ApiModelProperty(value="法人",required = true)
	@NotEmpty(message="法人为空")
    private String legalPerson;

    /**
     * 审核状态-1未审核，1-审核中，2-审核通过，3-审核不通过
     * Table:     f_shop
     * Column:    audit_state
     * Nullable:  true
     */
	@ApiModelProperty(value="审核状态",required = true)
    private String auditState;
	
	
	
	@ApiModelProperty(value="商户账号信息",required = true)
	@TableField(exist=false)
	private ShopAccount shopAccount;
	
	
	
	@ApiModelProperty(value="0-商家身份证，1-法人身份证，2-营业执照",required = true)
	@TableField(exist=false)
	List<ShopAttach> shopAttachs;
}