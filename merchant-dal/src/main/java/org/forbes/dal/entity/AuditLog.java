package org.forbes.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Table: f_audit_log
 */
@Data
@ApiModel(description="商家附件")
@EqualsAndHashCode(callSuper = false)
@TableName("f_audit_log")
public class AuditLog extends BaseEntity {

	
	private static final long serialVersionUID = -3466798685280188854L;

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