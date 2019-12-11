package org.forbes.dal.entity;

import lombok.Data;

/**
 * Table: f_audit_log
 */
@Data
public class AuditLog extends BaseEntity {

    /**
     * 商家ID
     * Table:     f_audit_log
     * Column:    shop_id
     * Nullable:  true
     */
    private Long shopId;

    /**
     * 操作内容
     * Table:     f_audit_log
     * Column:    opr_content
     * Nullable:  true
     */
    private String oprContent;
}