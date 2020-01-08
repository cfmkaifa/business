package org.forbes.biz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.forbes.comm.model.BasePageDto;
import org.forbes.comm.model.ShopDepositPageDto;
import org.forbes.comm.vo.ShopDepositVo;
import org.forbes.dal.entity.ShopDeposit;

public interface IShopDepoistService extends IService<ShopDeposit> {

    /***
     * shopDepositPage方法概述:分页查询商家预存款信息
     * @param pageDto
     * @return
     * @创建人 niehy(Frunk)
     * @创建时间 2019/12/25
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    IPage<ShopDepositVo> shopDepositPage(IPage<ShopDepositVo> page, ShopDepositPageDto pageDto);
}
