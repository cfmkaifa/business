package org.forbes.biz.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.forbes.biz.IShopGradeService;
import org.forbes.biz.IShopTypeService;
import org.forbes.dal.entity.ShopGrade;
import org.forbes.dal.entity.ShopType;
import org.forbes.dal.mapper.ShopGradeMapper;
import org.forbes.dal.mapper.ShopTypeMapper;
import org.springframework.stereotype.Service;

/**
 * @author lzw
 * @date 2019/12/23 15:01
 */
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {
}
