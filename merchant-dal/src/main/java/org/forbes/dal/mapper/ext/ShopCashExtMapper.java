package org.forbes.dal.mapper.ext;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.forbes.comm.model.ShopCashDto;
import org.forbes.comm.vo.ShopCashVo;
import org.forbes.dal.entity.ShopCash;

/**
 * @author lzw
 * @date 2019/12/25 14:58
 */
public interface ShopCashExtMapper extends BaseMapper<ShopCash> {

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
