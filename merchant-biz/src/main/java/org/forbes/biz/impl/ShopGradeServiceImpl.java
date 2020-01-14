package org.forbes.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.forbes.biz.IShopGradeService;
import org.forbes.biz.IShopService;
import org.forbes.comm.constant.ShopCommonConstant;
import org.forbes.comm.enums.BizResultEnum;
import org.forbes.comm.exception.ForbesException;
import org.forbes.comm.utils.ConvertUtils;
import org.forbes.dal.entity.Shop;
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

    @Autowired
    IShopService shopService;

    /***批量删除店铺等级
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        idList.stream().forEach(id->{
            ShopGrade shopGrade = this.getById(id);
            if(ConvertUtils.isEmpty(shopGrade)){
                throw new ForbesException(BizResultEnum.ENTITY_EMPTY.getBizCode(),BizResultEnum.ENTITY_EMPTY.getBizMessage());
            }
            int count = shopService.count(new QueryWrapper<Shop>().eq(ShopCommonConstant.GRADE_ID,shopGrade.getId()));
            //等级正在被使用中
            if(count > 0){
                throw new ForbesException(BizResultEnum.SHOP_GRADE_USED.getBizCode(),BizResultEnum.SHOP_GRADE_USED.getBizMessage());
            }
        });
        boolean delBool =  SqlHelper.delBool(baseMapper.deleteBatchIds(idList));
        return delBool;
    }
}
