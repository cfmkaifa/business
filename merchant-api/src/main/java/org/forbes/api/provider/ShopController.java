package org.forbes.api.provider;

import org.forbes.biz.IShopService;
import org.forbes.comm.constant.DataColumnConstant;
import org.forbes.comm.constant.SaveValid;
import org.forbes.comm.enums.BizResultEnum;
import org.forbes.comm.exception.ForbesException;
import org.forbes.comm.vo.Result;
import org.forbes.dal.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController(value="apiShopController")
@RequestMapping("/shop-api")
@Api(tags={"商家外部接口调用"})
@Slf4j
public class ShopController {

	
//	@Autowired
//	IShopService  shopService;
//
//	/***
//	 * registerShop方法慨述:商家注册
//	 * @param shop
//	 * @return Result<Shop>
//	 * @创建人 huanghy
//	 * @创建时间 2019年12月16日 下午2:44:03
//	 * @修改人 (修改了该文件，请填上修改人的名字)
//	 * @修改日期 (请填上修改该文件时的日期)
//	 */
//	 @RequestMapping(value = "/register",method = RequestMethod.POST)
//	    @ApiOperation("商家注册")
//	    @ApiResponses(value = {
//	            @ApiResponse(code=500,message = Result.COMM_ACTION_ERROR_MSG),
//	            @ApiResponse(code=200,message = Result.COMM_ACTION_MSG)
//	    })
//	    public Result<Shop> registerShop(@RequestBody @Validated(value=SaveValid.class)Shop shop){
//	        log.debug("===========sysUserDto:"+JSON.toJSONString(shop));
//	        Result<Shop> result = new Result<Shop>();
//	        try{
//	        	 String name = shop.getName();
//	 	        int nameCount = shopService.count(new QueryWrapper<Shop>().eq(DataColumnConstant.NAME, name));
//	 	        if(nameCount > 0){
//	 	        	 result.setBizCode(BizResultEnum.SHOP_EXISTS.getBizCode());
//	 	             result.setMessage(String.format(BizResultEnum.SHOP_EXISTS.getBizFormateMessage(), name));
//	 	             return result;
//	 	        }
//	 	        String phone = shop.getPhone();
//	 	        int phonCount = shopService.count(new QueryWrapper<Shop>().eq(DataColumnConstant.PHONE, phone));
//	 	        if(phonCount > 0){
//	 	        	 result.setBizCode(BizResultEnum.SHOP_PHONE_EXISTS.getBizCode());
//	 	             result.setMessage(String.format(BizResultEnum.SHOP_PHONE_EXISTS.getBizFormateMessage(), name));
//	 	             return result;
//	 	        }
//	 	        shopService.registShop(shop);
//	 	        result.setResult(shop);
//	        }catch(ForbesException e){
//	        	result.setBizCode(e.getErrorCode());
//	        	result.setMessage(e.getErrorMsg());
//	        }
//	        return result;
//	    }
}
