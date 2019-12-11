package org.forbes.dal.mapper;

import org.forbes.dal.entity.ShopAccount;

public interface ShopAccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShopAccount record);

    int insertSelective(ShopAccount record);

    ShopAccount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopAccount record);

    int updateByPrimaryKey(ShopAccount record);
}