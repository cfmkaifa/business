package org.forbes.biz.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.forbes.biz.IShopRegistrationItemService;
import org.forbes.dal.entity.ShopRegistrationItem;
import org.forbes.dal.mapper.ShopRegistrationItemMapper;
import org.springframework.stereotype.Service;

/**
 * @author frunk
 */
@Service
public class IShopRegistrationItemServiceImpl extends ServiceImpl<ShopRegistrationItemMapper,ShopRegistrationItem> implements IShopRegistrationItemService {
}
