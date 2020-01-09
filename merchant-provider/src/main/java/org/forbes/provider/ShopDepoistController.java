package org.forbes.provider;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.forbes.biz.IShopDepoistService;
import org.forbes.comm.model.BasePageDto;
import org.forbes.comm.model.ShopDepositPageDto;
import org.forbes.comm.vo.Result;
import org.forbes.comm.vo.ShopDepositVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@Api(tags = {"商家预存款控制层"})
@RestController
@RequestMapping("/shop-depoist")
public class ShopDepoistController {

    @Autowired
    IShopDepoistService shopDepoistService;


    /***
     * page方法概述:分页查询商家预存款信息
     * @param pageDto
     * @return
     * @创建人 niehy(Frunk)
     * @创建时间 2019/12/25
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ApiOperation("分页查询商家预存款信息")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = Result.SHOP_DEPOIST_ERROR_MSG),
            @ApiResponse(code = 200, message = Result.SHOP_DEPOIST_MSG)
    })
    public Result<IPage<ShopDepositVo>> page(BasePageDto basePageDto, ShopDepositPageDto pageDto){
        log.debug("传入参数为:" + JSON.toJSONString(pageDto));
        Result<IPage<ShopDepositVo>> result = new Result<>();
        IPage<ShopDepositVo> page = new Page<ShopDepositVo>(basePageDto.getPageNo(),basePageDto.getPageSize());
        IPage<ShopDepositVo> deposits = shopDepoistService.shopDepositPage(page,pageDto);
        result.setResult(deposits);
        log.debug("返回值为:" + JSON.toJSONString(result.getResult()));
        return result;
    }



}
