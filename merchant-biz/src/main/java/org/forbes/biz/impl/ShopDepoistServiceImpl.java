package org.forbes.biz.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.forbes.biz.IShopDepoistService;
import org.forbes.comm.model.BasePageDto;
import org.forbes.comm.model.ShopDepositPageDto;
import org.forbes.comm.vo.ShopDepositVo;
import org.forbes.dal.entity.ShopDeposit;
import org.forbes.dal.mapper.ShopDepositMapper;
import org.forbes.dal.mapper.ext.ShopDepositExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopDepoistServiceImpl extends ServiceImpl<ShopDepositMapper, ShopDeposit> implements IShopDepoistService {

    @Autowired
    ShopDepositExtMapper shopDepositExtMapper;

    /***
     * shopDepositPage方法概述:分页查询商家预存款信息
     * @param pageDto
     * @return
     * @创建人 niehy(Frunk)
     * @创建时间 2019/12/25
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @Override
    public IPage<ShopDepositVo> shopDepositPage(IPage<ShopDepositVo> page, ShopDepositPageDto pageDto) {
        return shopDepositExtMapper.shopDepositPage(page,pageDto);
    }
}
