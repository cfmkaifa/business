package org.forbes.dal.mapper;

import org.forbes.dal.entity.ShopAttach;

public interface ShopAttachMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShopAttach record);

    int insertSelective(ShopAttach record);

    ShopAttach selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopAttach record);

    int updateByPrimaryKey(ShopAttach record);
}