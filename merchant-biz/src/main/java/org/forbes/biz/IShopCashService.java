package org.forbes.biz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.forbes.comm.model.ShopCashDto;
import org.forbes.comm.vo.ShopCashVo;
import org.forbes.dal.entity.ShopCash;

/**
 * @author lzw
 * @date 2019/12/25 15:28
 */
public interface IShopCashService extends IService<ShopCash> {

    /***
     * pageUsers方法概述:分页查询商家提现
     * @param
     * @return
     * @创建人 Tom
     * @创建时间 2019/12/25 15:43
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    IPage<ShopCashVo> pageUsers(IPage<ShopCashVo> page, ShopCashDto shopCashDto);
}
