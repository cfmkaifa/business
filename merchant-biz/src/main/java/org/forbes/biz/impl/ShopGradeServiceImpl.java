package org.forbes.biz.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.forbes.biz.IShopGradeService;
import org.forbes.dal.entity.ShopGrade;
import org.forbes.dal.mapper.ShopGradeMapper;
import org.springframework.stereotype.Service;

/**
 * @author lzw
 * @date 2019/12/23 15:01
 */
@Service
public class ShopGradeServiceImpl extends ServiceImpl<ShopGradeMapper, ShopGrade> implements IShopGradeService {
}
