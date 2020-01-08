package org.forbes.provider;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.forbes.biz.IShopCashService;
import org.forbes.comm.enums.BizResultEnum;
import org.forbes.comm.enums.ShopCashStausEnum;
import org.forbes.comm.model.BasePageDto;
import org.forbes.comm.model.ShopCashDto;
import org.forbes.comm.model.SysUser;
import org.forbes.comm.utils.ConvertUtils;
import org.forbes.comm.vo.Result;
import org.forbes.comm.vo.ShopCashVo;
import org.forbes.dal.entity.ShopCash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lzw
 * @date 2019/12/25 15:31
 */
@RestController
@RequestMapping("/cash")
@Api(tags={"商家提现管理"})
@Slf4j
public class ShopCashController {

    @Autowired
    IShopCashService shopCashService;

    /***
     * selectCashList方法概述:商家提现分页查询
     * @param basePageDto, shopCashDto
     * @return org.forbes.comm.vo.Result<com.baomidou.mybatisplus.core.metadata.IPage<org.forbes.comm.vo.ShopCashVo>>
     * @创建人 Tom
     * @创建时间 2019/12/25 16:02
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ApiOperation("商家提现分页查询")
    @ApiResponses(value = {
            @ApiResponse(code=200,message = Result.SHOP_CASH_PAGE_MSG),
            @ApiResponse(code=500,message = Result.SHOP_CASH_PAGE_MSG_ERROR)
    })
    public Result<IPage<ShopCashVo>> selectCashList(BasePageDto basePageDto, ShopCashDto shopCashDto){
        Result<IPage<ShopCashVo>> result=new Result<IPage<ShopCashVo>>();
        IPage<ShopCashVo> page = new Page<ShopCashVo>(basePageDto.getPageNo(),basePageDto.getPageSize());
        IPage<ShopCashVo> pageUsers =  shopCashService.pageUsers(page, shopCashDto);
        result.setResult(pageUsers);
        return result;
    }

    /***
     * passOrNo方法概述:
     * @param id, status
     * @return org.forbes.comm.vo.Result<org.forbes.dal.entity.ShopCash>
     * @创建人 Tom
     * @创建时间 2019/12/25 16:10
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/pass-no/{id}",method = RequestMethod.PUT)
    @ApiOperation("通过/不通过提现")
    @ApiImplicitParam(value="status",name="提现状态",required=false)
    @ApiResponses(value = {
            @ApiResponse(code=500,message = Result.COMM_ACTION_ERROR_MSG),
            @ApiResponse(code=200,response = SysUser.class,message = Result.COMM_ACTION_MSG)
    })
    public Result<ShopCash> passOrNo(@PathVariable Long id,
                                     @RequestParam(value="status",required=true)String status){
        Result<ShopCash> result=new Result<ShopCash>();
        boolean isUserStatus = ShopCashStausEnum.existsShopStausEnum(status);
        if(!isUserStatus){
            result.setBizCode(BizResultEnum.SHOP_CASH_STATUS_NO_EXISTS.getBizCode());
            result.setMessage(String.format(BizResultEnum.SHOP_CASH_STATUS_NO_EXISTS.getBizFormateMessage(), status));
            return result;
        }
        ShopCash shopCash = shopCashService.getById(id);
        if(ConvertUtils.isEmpty(shopCash)){
            result.setBizCode(BizResultEnum.ENTITY_EMPTY.getBizCode());
            result.setMessage(BizResultEnum.ENTITY_EMPTY.getBizMessage());
            return result;
        }
        shopCash.setStatus(status);
        shopCashService.updateById(shopCash);
        return result;
    }
}
