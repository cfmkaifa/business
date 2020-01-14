package org.forbes.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.forbes.biz.IShopRegistrationItemService;
import org.forbes.comm.constant.SaveValid;
import org.forbes.comm.constant.ShopRegCommonConstant;
import org.forbes.comm.enums.BizResultEnum;
import org.forbes.comm.model.BasePageDto;
import org.forbes.comm.model.RegistrationItemPageDto;
import org.forbes.comm.utils.ConvertUtils;
import org.forbes.comm.vo.Result;
import org.forbes.dal.entity.ShopRegistrationItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:商家注册项控制层
 *
 * @author frunk
 */
@RestController
@RequestMapping("/registration-item")
@Api(tags = {"商家注册项控制层"})
@Slf4j
public class ShopRegistrationItemController {


    @Autowired
    IShopRegistrationItemService itemService;


    /***
     * selectPage方法概述:分页查询商家注册项
     * @param basePageDto, shopGradeDto
     * @return ShopRegistrationItem
     * @创建人 Frunk
     * @创建时间 2019/12/23 16:23
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询商家注册项")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = Result.REGISTRATION_ITEM_PAGE_MSG_ERROR),
            @ApiResponse(code = 200, message = Result.REGISTRATION_ITEM_PAGE_MSG)
    })
    public Result<IPage<ShopRegistrationItem>> selectPage(BasePageDto basePageDto, RegistrationItemPageDto pageDto) {
        Result<IPage<ShopRegistrationItem>> result = new Result<>();
        QueryWrapper<ShopRegistrationItem> qw = new QueryWrapper<ShopRegistrationItem>();
        if (ConvertUtils.isNotEmpty(pageDto)) {
            //商家注册项名称条件搜索
            if (ConvertUtils.isNotEmpty(pageDto.getName())) {
                qw.like(ShopRegCommonConstant.REGISTRATION_NAME, pageDto.getName());
            }
        }
        IPage<ShopRegistrationItem> page = new Page<ShopRegistrationItem>(basePageDto.getPageNo(), basePageDto.getPageSize());
        IPage<ShopRegistrationItem> itemIPage = itemService.page(page, qw);
        result.setResult(itemIPage);
        return result;
    }


    /***
     * selectPage方法概述:增加查询商家注册项
     * @param registrationItem
     * @return ShopRegistrationItem
     * @创建人 Frunk
     * @创建时间 2019/12/23 16:23
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ApiOperation(value = "增加查询商家注册项")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = Result.REGISTRATION_ITEM_PAGE_MSG_ERROR),
            @ApiResponse(code = 200, message = Result.REGISTRATION_ITEM_PAGE_MSG)
    })
    public Result<ShopRegistrationItem> add(@RequestBody @Validated(value = SaveValid.class) ShopRegistrationItem registrationItem) {
        Result<ShopRegistrationItem> result = new Result<>();
        if (ConvertUtils.isEmpty(registrationItem)) {
            result.setBizCode(BizResultEnum.ENTITY_EMPTY.getBizCode());
            result.setMessage(BizResultEnum.ENTITY_EMPTY.getBizMessage());
            return result;
        }
        int existCount = itemService.count(new QueryWrapper<ShopRegistrationItem>().eq(ShopRegCommonConstant.REGISTRATION_NAME, registrationItem.getName()));
        if (existCount > 0) {
            result.setBizCode(BizResultEnum.SHOP_REGISTRATION_NAME_EXISTS.getBizCode());
            result.setMessage(BizResultEnum.SHOP_REGISTRATION_NAME_EXISTS.getBizMessage());
            return result;
        }

        itemService.save(registrationItem);
        result.setResult(registrationItem);
        return result;
    }















}
