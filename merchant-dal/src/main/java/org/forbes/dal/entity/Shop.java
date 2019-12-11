package org.forbes.dal.entity;

import java.util.Date;
import lombok.Data;

/**
 * Table: f_shop
 */
@Data
public class Shop extends BaseEntity {
    /**
     * 主键
     * Table:     f_shop
     * Column:    id
     * Nullable:  false
     */
    private Long id;

    /**
     * Table:     f_shop
     * Column:    create_by
     * Nullable:  true
     */
    private String createBy;

    /**
     * 创建时间
     * Table:     f_shop
     * Column:    create_time
     * Nullable:  true
     */
    private Date createTime;

    /**
     * 更新人
     * Table:     f_shop
     * Column:    update_by
     * Nullable:  true
     */
    private String updateBy;

    /**
     * 更新时间
     * Table:     f_shop
     * Column:    update_time
     * Nullable:  true
     */
    private Date updateTime;

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