package org.forbes.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.forbes.biz.IShopGradeService;
import org.forbes.biz.IShopTypeService;
import org.forbes.comm.constant.DataColumnConstant;
import org.forbes.dal.entity.ShopGrade;
import org.forbes.dal.entity.ShopType;
import org.forbes.dal.mapper.ShopGradeMapper;
import org.forbes.dal.mapper.ShopTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author lzw
 * @date 2019/12/23 15:01
 */
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {

    @Autowired
    ShopTypeMapper shopTypeMapper;

    /***
     *  删除店铺分类
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean removeById(Serializable id) {
        shopTypeMapper.delete(new QueryWrapper<ShopType>().eq(DataColumnConstant.ID, id));
        boolean delBool =  SqlHelper.delBool(baseMapper.deleteById(id));
        return delBool;
    }


    /***批量删除店铺分类
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        shopTypeMapper.delete(new QueryWrapper<ShopType>().in(DataColumnConstant.ID, idList));
        boolean delBool =  SqlHelper.delBool(baseMapper.deleteBatchIds(idList));
        return delBool;
    }
}
