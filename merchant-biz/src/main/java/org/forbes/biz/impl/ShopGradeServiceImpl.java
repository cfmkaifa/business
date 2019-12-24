package org.forbes.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.forbes.biz.IShopGradeService;
import org.forbes.comm.constant.DataColumnConstant;
import org.forbes.dal.entity.ShopGrade;
import org.forbes.dal.mapper.ShopGradeMapper;
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
public class ShopGradeServiceImpl extends ServiceImpl<ShopGradeMapper, ShopGrade> implements IShopGradeService {

    @Autowired
    ShopGradeMapper shopGradeMapper;

    /***
     *  删除店铺等级
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean removeById(Serializable id) {
        shopGradeMapper.delete(new QueryWrapper<ShopGrade>().eq(DataColumnConstant.ID, id));
        boolean delBool =  SqlHelper.delBool(baseMapper.deleteById(id));
        return delBool;
    }


    /***批量删除店铺等级
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        shopGradeMapper.delete(new QueryWrapper<ShopGrade>().in(DataColumnConstant.ID, idList));
        boolean delBool =  SqlHelper.delBool(baseMapper.deleteBatchIds(idList));
        return delBool;
    }
}
