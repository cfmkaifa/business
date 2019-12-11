package org.forbes.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Table: f_shop
 */
@Data
@ApiModel(description="商家信息")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("f_shop")
public class Shop extends BaseEntity {
    /**
     * Table:     f_shop
     * Column:    name
     * Nullable:  true
     */
    private String name;

    /**
     * Table:     f_shop
     * Column:    email
     * Nullable:  true
     */
    private String email;

    /**
     * Table:     f_shop
     * Column:    phone
     * Nullable:  true
     */
    private String phone;

    /**
     * Table:     f_shop
     * Column:    fax
     * Nullable:  true
     */
    private String fax;

    /**
     * 机构代码
     * Table:     f_shop
     * Column:    org_code
     * Nullable:  true
     */
    private String orgCode;

    /**
     * 法人
     * Table:     f_shop
     * Column:    legal_person
     * Nullable:  true
     */
    private String legalPerson;

    /**
     * 审核状态-1未审核，1-审核中，2-审核通过，3-审核不通过
     * Table:     f_shop
     * Column:    audit_state
     * Nullable:  true
     */
    private String auditState;
}