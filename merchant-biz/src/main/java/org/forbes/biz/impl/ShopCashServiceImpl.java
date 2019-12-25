package org.forbes.biz.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.forbes.biz.IShopCashService;
import org.forbes.comm.model.ShopCashDto;
import org.forbes.comm.vo.ShopCashVo;
import org.forbes.dal.entity.ShopCash;
import org.forbes.dal.mapper.ShopCashMapper;
import org.forbes.dal.mapper.ext.ShopCashExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lzw
 * @date 2019/12/25 15:29
 */
@Service
public class ShopCashServiceImpl extends ServiceImpl<ShopCashMapper, ShopCash> implements IShopCashService{

    @Autowired
    ShopCashExtMapper shopCashExtMapper;

    /***
     * pageUsers方法概述:分页查询商家提现
     * @param
     * @return
     * @创建人 Tom
     * @创建时间 2019/12/25 15:43
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @Override
    public IPage<ShopCashVo> pageUsers(IPage<ShopCashVo> page, ShopCashDto shopCashDto) {
        return shopCashExtMapper.pageUsers(page,shopCashDto);
    }
}
