package org.forbes.biz.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.dubbo.config.annotation.Reference;
import org.forbes.biz.IShopService;
import org.forbes.comm.constant.CommonConstant;
import org.forbes.comm.enums.AdminFlagEnum;
import org.forbes.comm.enums.BizResultEnum;
import org.forbes.comm.enums.DataTypeEnum;
import org.forbes.comm.enums.ShopStausEnum;
import org.forbes.comm.exception.ForbesException;
import org.forbes.comm.model.PageShopDto;
import org.forbes.comm.model.RemoteSysUserDto;
import org.forbes.comm.utils.ConvertUtils;
import org.forbes.comm.vo.Result;
import org.forbes.comm.vo.ShopUserVo;
import org.forbes.dal.entity.Shop;
import org.forbes.dal.entity.ShopAccount;
import org.forbes.dal.entity.ShopAttach;
import org.forbes.dal.mapper.ShopAccountMapper;
import org.forbes.dal.mapper.ShopAttachMapper;
import org.forbes.dal.mapper.ShopMapper;
import org.forbes.dal.mapper.ext.ShopExtMapper;
import org.forbes.servcie.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransactionContext;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lzw
 * @date 2019/12/11 11:11
 */
@Slf4j
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService{

	
	@Autowired
	ShopExtMapper shopExtMapper;
	
	@Reference(version = "1.0.0", timeout = 60000)
	private ISysUserService sysUserService;
	@Autowired
	ShopAccountMapper shopAccountMapper;
	@Autowired
	ShopAttachMapper  shopAttachMapper;
	
	
	
	/***全局事务
	 */
	@GlobalTransactional
	@Transactional(rollbackFor=Exception.class)
	public void registShop(Shop shop){
		try {
			shop.setAuditState(ShopStausEnum.UNAUDITED.getCode());
			baseMapper.insert(shop);
			Long shopId = shop.getId();
			List<ShopAttach> shopAttachs = shop.getShopAttachs();
			if(ConvertUtils.isNotEmpty(shopAttachs)){
				long dataTypeCount = shopAttachs.stream().filter(shopAttach -> !DataTypeEnum.existsCode(shopAttach.getDataType())).count();
				if(dataTypeCount > 0 ){
					throw new ForbesException(BizResultEnum.ATTCH_DATA_TYPE_ERROR_MSG.getBizCode(),BizResultEnum.ATTCH_DATA_TYPE_ERROR_MSG.getBizMessage());
				}
				shopAttachs.forEach(shopAttach -> {
					shopAttach.setDataId(shopId);
					shopAttachMapper.insert(shopAttach);
				});
			}
			ShopAccount shopAccount = shop.getShopAccount();
			if(ConvertUtils.isEmpty(shopAccount)){
				shopAccount = new ShopAccount();
			}
			shopAccount.setShopId(shopId);
			if(ConvertUtils.isEmpty(shopAccount.getRealname())){
				shopAccount.setRealname(shop.getName());
			}
			if(ConvertUtils.isEmpty(shopAccount.getUsername())){
				shopAccount.setUsername(shop.getPhone());
			}
			if(ConvertUtils.isEmpty(shopAccount.getPassword())){
				shopAccount.setPassword(CommonConstant.DEFAULT_PASSWD);
			}
			String phone = shop.getPhone();
			shopAccount.setPhone(phone);
			/***增加用户**/
			RemoteSysUserDto sysUserDto = new RemoteSysUserDto();
			sysUserDto.setUsername(shopAccount.getUsername());
			sysUserDto.setPassword(shopAccount.getPassword());
			sysUserDto.setAdminFlag(AdminFlagEnum.ORDINARY.getCode());
			sysUserDto.setAvatar(shopAccount.getAvatar());
			sysUserDto.setPhone(phone);
			sysUserDto.setRealname(shopAccount.getRealname());
			Result<RemoteSysUserDto> result = sysUserService.registerUser(sysUserDto, "provider");
			if("0000".equals(result.getBizCode())){
				RemoteSysUserDto remoteSysUserDto = result.getResult();
				shopAccount.setUserId(remoteSysUserDto.getId());
				shopAccount.setShopId(shopId);
				shopAccount.setPassword(remoteSysUserDto.getPassword());
				shopAccount.setSalt(remoteSysUserDto.getSalt());
				shopAccountMapper.insert(shopAccount);
			} else {
				throw new ForbesException(result.getBizCode(),result.getMessage());
			}
		}catch(Exception e){
			try {
				e.printStackTrace();
				GlobalTransactionContext.reload(RootContext.getXID()).rollback();
				if ( !(e instanceof ForbesException)){
					throw new ForbesException(BizResultEnum.REMOTE_ERROR_MSG.getBizCode(),e.getMessage());
				}
				throw e;
			} catch (TransactionException e1) {
				log.trace("全局事务回滚异常：",e1);
				throw new ForbesException(BizResultEnum.REMOTE_ERROR_MSG.getBizCode(),BizResultEnum.REMOTE_ERROR_MSG.getBizMessage());
			}
		}
	}

	/***
	 * getByName方法概述:根据名字查询商家信息
	 * @param
	 * @return
	 * @创建人 Tom
	 * @创建时间 2019/12/23 9:58
	 * @修改人 (修改了该文件，请填上修改人的名字)
	 * @修改日期 (请填上修改该文件时的日期)
	 */
	@Override
	public Shop getByName(String name) {
		return shopExtMapper.getByName(name);
	}

}
