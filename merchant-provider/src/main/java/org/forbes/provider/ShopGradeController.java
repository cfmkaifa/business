package org.forbes.provider;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.forbes.biz.IShopGradeService;
import org.forbes.comm.constant.DataColumnConstant;
import org.forbes.comm.constant.PermsCommonConstant;
import org.forbes.comm.constant.SaveValid;
import org.forbes.comm.enums.BizResultEnum;
import org.forbes.comm.enums.ShopGradeEnum;
import org.forbes.comm.model.BasePageDto;
import org.forbes.comm.model.ShopGradeDto;
import org.forbes.comm.model.SysRole;
import org.forbes.comm.utils.ConvertUtils;
import org.forbes.comm.vo.Result;
import org.forbes.dal.entity.ShopGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzw
 * @date 2019/12/23 14:57
 */
@RestController
@RequestMapping("/grade")
@Api(tags={"商家等级管理"})
@Slf4j
public class ShopGradeController  {

    @Autowired
    IShopGradeService shopGradeService;

    /***
     * selectPage方法概述:分页查询店铺等级
     * @param basePageDto, shopGradeDto
     * @return org.forbes.comm.vo.Result<com.baomidou.mybatisplus.core.metadata.IPage<org.forbes.dal.entity.ShopGrade>>
     * @创建人 Tom
     * @创建时间 2019/12/23 16:23
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ApiOperation(value="分页查询店铺等级")
    @ApiResponses(value={
            @ApiResponse(code=500,message= Result.SHOP_GRADE_PAGE_MSG_ERROR),
            @ApiResponse(code=200,message = Result.SHOP_GRADE_PAGE_MSG)
    })
    public Result<IPage<ShopGrade>> selectPage(BasePageDto basePageDto,ShopGradeDto shopGradeDto){
        Result<IPage<ShopGrade>> result = new Result<>();
        QueryWrapper<ShopGrade> qw = new QueryWrapper<ShopGrade>();
        if (ConvertUtils.isNotEmpty(shopGradeDto)) {
            if(ConvertUtils.isNotEmpty(shopGradeDto.getName()) ){
                qw.like(PermsCommonConstant.NAME,shopGradeDto.getName());
            }
        }
        IPage<ShopGrade> page = new Page<ShopGrade>(basePageDto.getPageNo(),basePageDto.getPageSize());
        IPage<ShopGrade> shopGradeIPage = shopGradeService.page(page,qw);
        result.setResult(shopGradeIPage);
        return result;
    }

    /***
     * addShopGrade方法概述:
     * @param shopGrade
     * @return org.forbes.comm.vo.Result<org.forbes.dal.entity.ShopGrade>
     * @创建人 Tom
     * @创建时间 2019/12/23 16:26
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("增加店铺等级")
    @ApiResponses(value={
            @ApiResponse(code=500,message= Result.ADD_SHOP_GRADE_MSG_ERROR),
            @ApiResponse(code=200,message = Result.ADD_SHOP_GRADE_MSG)
    })
    public Result<ShopGrade> addShopGrade(@RequestBody @Validated(value=SaveValid.class) ShopGrade shopGrade){
        Result<ShopGrade> result=new Result<ShopGrade>();
        shopGrade.setGrade(ShopGradeEnum.ZREO.getCode());
        shopGradeService.save(shopGrade);
        result.setResult(shopGrade);
        return result;
    }



}
