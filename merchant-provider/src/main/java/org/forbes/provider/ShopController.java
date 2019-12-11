package org.forbes.provider;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.forbes.biz.IShopService;
import org.forbes.comm.enums.BizResultEnum;
import org.forbes.comm.enums.ShopStausEnum;
import org.forbes.comm.utils.ConvertUtils;
import org.forbes.comm.vo.Result;
import org.forbes.dal.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lzw
 * @date 2019/12/11 14:19
 */
@RestController
@RequestMapping("/shop")
@Api(tags={"商家管理"})
@Slf4j
public class ShopController {

    @Autowired
    IShopService shopService;

    /***
     * updateShopAuditState方法概述:
     * @param 
     * @return 
     * @创建人 Tom
     * @创建时间 2019/12/11 14:22
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/update-shop-auditstate/{id}",method = RequestMethod.PUT)
    @ApiOperation("审核冻结用户")
    @ApiImplicitParam(value="auditState",name="商家状态",required=false)
    @ApiResponses(value = {
            @ApiResponse(code=500,message = Result.COMM_ACTION_ERROR_MSG),
            @ApiResponse(code=200,response = Shop.class,message = Result.COMM_ACTION_MSG)
    })
    public Result<Shop> updateShopAuditState(@PathVariable Long id, @RequestParam(value="auditState",required=true)String auditState){
        Result<Shop> result=new Result<Shop>();
        boolean isUserStatus = ShopStausEnum.existsShopStausEnum(auditState);
        if(!isUserStatus){
            result.setBizCode(BizResultEnum.SHOP_STATUS_NO_EXISTS.getBizCode());
            result.setMessage(String.format(BizResultEnum.SHOP_STATUS_NO_EXISTS.getBizFormateMessage(), auditState));
            return result;
        }
        Shop shop = shopService.getById(id);
        if(ConvertUtils.isEmpty(shop)){
            result.setBizCode(BizResultEnum.ENTITY_EMPTY.getBizCode());
            result.setMessage(BizResultEnum.ENTITY_EMPTY.getBizMessage());
            return result;
        }
        shop.setAuditState(auditState);
        shopService.updateById(shop);
        return result;
    }




}
