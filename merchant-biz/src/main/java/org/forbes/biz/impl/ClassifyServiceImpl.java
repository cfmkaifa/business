package org.forbes.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.forbes.biz.IShopClassifyService;
import org.forbes.biz.IClassifyService;
import org.forbes.comm.constant.ShopClassifyCommonConstant;
import org.forbes.comm.enums.BizResultEnum;
import org.forbes.comm.exception.ForbesException;
import org.forbes.comm.utils.ConvertUtils;
import org.forbes.dal.entity.Classify;
import org.forbes.dal.entity.ShopClassify;
import org.forbes.dal.mapper.ClassifyMapper;
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
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify> implements IClassifyService {

    @Autowired
    IShopClassifyService shopClassifyService;

    /***
     * removeByIds方法概述:批量删除经营分类
     * @param idList
     * @return boolean
     * @创建人 niehy(Frunk)
     * @创建时间 2020/1/8
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        idList.stream().forEach(id -> {
            Classify shopType = this.getById(id);
            if (ConvertUtils.isEmpty(shopType)) {
                throw new ForbesException(BizResultEnum.ENTITY_EMPTY.getBizCode(), BizResultEnum.ENTITY_EMPTY.getBizMessage());
            }
            //判断该分类下是否还有其他商家
            int shopCount = shopClassifyService.count(new QueryWrapper<ShopClassify>().eq(ShopClassifyCommonConstant.CLASSIFY_ID,id));
            if (shopCount > 0) {
                throw new ForbesException(BizResultEnum.CLASSIFY_TYPE_ID_EXISTS.getBizCode(), BizResultEnum.CLASSIFY_TYPE_ID_EXISTS.getBizMessage());
            }
        });
        boolean delBool = SqlHelper.delBool(baseMapper.deleteBatchIds(idList));
        return delBool;
    }
}
