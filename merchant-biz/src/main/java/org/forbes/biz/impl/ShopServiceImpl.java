package org.forbes.biz.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.forbes.biz.IShopService;
import org.forbes.dal.entity.Shop;
import org.forbes.dal.mapper.ShopMapper;
import org.forbes.dal.mapper.ext.ShopExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lzw
 * @date 2019/12/11 11:11
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService{


}
