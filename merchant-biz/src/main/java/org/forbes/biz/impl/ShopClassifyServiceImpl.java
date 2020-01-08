package org.forbes.biz.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.forbes.biz.IShopClassifyService;
import org.forbes.dal.entity.ShopClassify;
import org.forbes.dal.mapper.ShopClassifyMapper;
import org.springframework.stereotype.Service;

@Service
public class ShopClassifyServiceImpl extends ServiceImpl<ShopClassifyMapper, ShopClassify> implements IShopClassifyService {
}
