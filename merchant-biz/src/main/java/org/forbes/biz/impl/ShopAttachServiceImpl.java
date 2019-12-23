package org.forbes.biz.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.forbes.biz.IShopAttachService;
import org.forbes.dal.entity.ShopAttach;
import org.forbes.dal.mapper.ShopAttachMapper;
import org.springframework.stereotype.Service;

/**
 * @author lzw
 * @date 2019/12/23 15:57
 */
@Service
public class ShopAttachServiceImpl extends ServiceImpl<ShopAttachMapper, ShopAttach> implements IShopAttachService {
}
