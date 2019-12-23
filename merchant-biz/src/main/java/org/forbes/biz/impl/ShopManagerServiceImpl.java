package org.forbes.biz.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.forbes.biz.IShopService;
import org.forbes.dal.entity.Shop;
import org.forbes.dal.mapper.ShopMapper;
import org.springframework.stereotype.Service;

@Service("shopManagerService")
public class ShopManagerServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {
    @Override
    public void registShop(Shop shop) {

    }

    @Override
    public Shop getByName(String name) {
        return null;
    }
}
