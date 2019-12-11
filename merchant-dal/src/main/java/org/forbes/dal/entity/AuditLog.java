package org.forbes.dal.entity;

import java.util.Date;
import lombok.Data;

/**
 * Table: f_audit_log
 */
@Data
public class AuditLog extends BaseEntity {
    /**
     * 主键
     * Table:     f_audit_log
     * Column:    id
     * Nullable:  false
     */
    private Long id;

    /**
     * Table:     f_audit_log
     * Column:    create_by
     * Nullable:  true
     */
    private String createBy;

    /**
     * 创建时间
     * Table:     f_audit_log
     * Column:    create_time
     * Nullable:  true
     */
    private Date createTime;

    /**
     * 更新人
     * Table:     f_audit_log
     * Column:    update_by
     * Nullable:  true
     */
    private String updateBy;

    /**
     * 更新时间
     * Table:     f_audit_log
     * Column:    update_time
     * Nullable:  true
     */
    private Date updateTime;

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