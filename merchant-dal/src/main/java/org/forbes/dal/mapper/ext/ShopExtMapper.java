package org.forbes.dal.mapper.ext;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.forbes.comm.model.PageShopDto;
import org.forbes.comm.vo.ShopUserVo;
import org.forbes.dal.entity.Shop;

/**
 * @author lzw
 * @date 2019/12/20 11:42
 */
public interface ShopExtMapper extends BaseMapper<Shop>{

    /***
     * getByName方法概述:根据名字查询商家信息
     * @param
     * @return
     * @创建人 Tom
     * @创建时间 2019/12/23 9:58
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    Shop getByName(String name);

}
