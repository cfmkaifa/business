package org.forbes.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import org.forbes.dal.entity.Shop;

/**
 * @author lzw
 * @date 2019/12/11 11:09
 */

public interface IShopService extends IService<Shop> {

//	/***
//	 * registShop方法慨述:注册商家
//	 * @param shop void
//	 * @创建人 huanghy
//	 * @创建时间 2019年12月16日 下午1:17:39
//	 * @修改人 (修改了该文件，请填上修改人的名字)
//	 * @修改日期 (请填上修改该文件时的日期)
//	 */
//	void registShop(Shop shop);

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
