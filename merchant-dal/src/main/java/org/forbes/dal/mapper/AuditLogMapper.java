package org.forbes.dal.mapper;

import org.forbes.dal.entity.AuditLog;

public interface AuditLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AuditLog record);

    int insertSelective(AuditLog record);

    AuditLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuditLog record);

    int updateByPrimaryKey(AuditLog record);
}