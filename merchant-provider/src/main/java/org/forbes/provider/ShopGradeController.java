package org.forbes.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.forbes.biz.IShopGradeService;
import org.forbes.biz.IShopService;
import org.forbes.comm.constant.*;
import org.forbes.comm.enums.BizResultEnum;
import org.forbes.comm.enums.ShopGradeEnum;
import org.forbes.comm.exception.ForbesException;
import org.forbes.comm.model.BasePageDto;
import org.forbes.comm.model.ShopGradeDto;
import org.forbes.comm.utils.ConvertUtils;
import org.forbes.comm.vo.Result;
import org.forbes.dal.entity.Shop;
import org.forbes.dal.entity.ShopGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author frunk
 * @date 2019/12/23 14:57
 */
@RestController
@RequestMapping("/grade")
@Api(tags = {"店铺等级管理"})
@Slf4j
public class ShopGradeController {

    @Autowired
    IShopGradeService shopGradeService;

    @Autowired
    @Qualifier(value = "shopManagerService")
    IShopService shopService;

    /***
     * selectPage方法概述:分页查询店铺等级
     * @param basePageDto, shopGradeDto
     * @return ShopGrade
     * @创建人 Frunk
     * @创建时间 2019/12/23 16:23
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询店铺等级")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = Result.SHOP_GRADE_PAGE_MSG_ERROR),
            @ApiResponse(code = 200, message = Result.SHOP_GRADE_PAGE_MSG)
    })
    public Result<IPage<ShopGrade>> selectPage(BasePageDto basePageDto, ShopGradeDto shopGradeDto) {
        Result<IPage<ShopGrade>> result = new Result<>();
        QueryWrapper<ShopGrade> qw = new QueryWrapper<ShopGrade>();
        if (ConvertUtils.isNotEmpty(shopGradeDto)) {
            //等级名称条件搜索
            if (ConvertUtils.isNotEmpty(shopGradeDto.getGradeName())) {
                qw.like(ShopGradeCommonConstant.GRADE_NAME, shopGradeDto.getGradeName());
            }
        }
        IPage<ShopGrade> page = new Page<ShopGrade>(basePageDto.getPageNo(), basePageDto.getPageSize());
        IPage<ShopGrade> shopGradeIPage = shopGradeService.page(page, qw);
        result.setResult(shopGradeIPage);
        return result;
    }

    /***
     * addShopGrade方法概述:增加店铺等级
     * @param shopGrade
     * @return ShopGrade
     * @创建人 Frunk
     * @创建时间 2019/12/23 16:26
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("增加店铺等级")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = Result.ADD_SHOP_GRADE_MSG_ERROR),
            @ApiResponse(code = 200, message = Result.ADD_SHOP_GRADE_MSG)
    })
    public Result<ShopGrade> addShopGrade(@RequestBody @Validated(value = SaveValid.class) ShopGrade shopGrade) {
        Result<ShopGrade> result = new Result<ShopGrade>();
        if (ConvertUtils.isEmpty(shopGrade)) {
            result.setBizCode(BizResultEnum.ENTITY_EMPTY.getBizCode());
            result.setMessage(BizResultEnum.ENTITY_EMPTY.getBizMessage());
            return result;
        }
        //等级名称为空
        if (ConvertUtils.isEmpty(shopGrade.getGradeName())) {
            result.setBizCode(BizResultEnum.EMPTY.getBizCode());
            result.setMessage(BizResultEnum.EMPTY.getBizMessage());
            return result;
        }
        //服务费为空
        if (ConvertUtils.isEmpty(shopGrade.getServiceCharge())) {
            result.setBizCode(BizResultEnum.EMPTY.getBizCode());
            result.setMessage(BizResultEnum.EMPTY.getBizMessage());
            return result;
        }
        int existShopGrade = shopGradeService.count(new QueryWrapper<ShopGrade>().eq(ShopGradeCommonConstant.GRADE_NAME, shopGrade.getGradeName()));
        //等级名称已存在
        if (existShopGrade > 0) {
            result.setBizCode(BizResultEnum.SHOP_GRADE_NAME_EXISTS.getBizCode());
            result.setMessage(BizResultEnum.SHOP_GRADE_NAME_EXISTS.getBizMessage());
            return result;
        }
        shopGradeService.save(shopGrade);
        result.setResult(shopGrade);
        return result;
    }

    /***
     * updateShopGrade方法概述:编辑店铺等级
     * @param shopGrade
     * @return ShopGrade
     * @创建人 Frunk
     * @创建时间 2019/12/23 17:31
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @ApiOperation("编辑店铺等级")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = Result.UPDATE_SHOP_GRADE_MSG),
            @ApiResponse(code = 500, message = Result.UPDATE_SHOP_GRADE_MSG_ERROR)
    })
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public Result<ShopGrade> updateShopGrade(@RequestBody @Validated(value = UpdateValid.class) ShopGrade shopGrade) {
        Result<ShopGrade> result = new Result<ShopGrade>();
        ShopGrade old = shopGradeService.getById(shopGrade.getId());
        //要修改的记录为空
        if (ConvertUtils.isEmpty(old)) {
            result.setBizCode(BizResultEnum.ENTITY_EMPTY.getBizCode());
            result.setMessage(BizResultEnum.ENTITY_EMPTY.getBizMessage());
            return result;
        }
        //等级名称为空
        if (ConvertUtils.isEmpty(shopGrade.getGradeName())) {
            result.setBizCode(BizResultEnum.EMPTY.getBizCode());
            result.setMessage(BizResultEnum.EMPTY.getBizMessage());
            return result;
        }
        //服务费为空
        if (ConvertUtils.isEmpty(shopGrade.getServiceCharge())) {
            result.setBizCode(BizResultEnum.EMPTY.getBizCode());
            result.setMessage(BizResultEnum.EMPTY.getBizMessage());
            return result;
        }
        shopGradeService.updateById(shopGrade);
        result.setResult(shopGrade);
        return result;
    }

    /***
     * delete方法概述:删除店铺等级
     * @param id
     * @return ShopGrade
     * @创建人 Frunk
     * @创建时间 2019/12/23 17:33
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @ApiOperation("删除店铺等级")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "店铺等级ID", required = true)
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = Result.DELETE_SHOP_GRADE_MSG),
            @ApiResponse(code = 500, message = Result.DELETE_SHOP_GRADE_MSG_ERROR)
    })
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result<ShopGrade> delete(@RequestParam(name = "id", required = true) String id) {
        Result<ShopGrade> result = new Result<ShopGrade>();
        ShopGrade shopGrade = shopGradeService.getById(id);
        if (ConvertUtils.isEmpty(shopGrade)) {
            result.setBizCode(BizResultEnum.ENTITY_EMPTY.getBizCode());
            result.setMessage(BizResultEnum.ENTITY_EMPTY.getBizMessage());
            return result;
        }
        int count = shopService.count(new QueryWrapper<Shop>().eq(ShopCommonConstant.GRADE_ID, shopGrade.getId()));
        //该等级正在被使用中
        if (count > 0) {
            result.setBizCode(BizResultEnum.SHOP_GRADE_USED.getBizCode());
            result.setMessage(BizResultEnum.SHOP_GRADE_USED.getBizMessage());
            return result;
        }
        shopGradeService.removeById(id);
        return result;
    }

    /***
     * deleteBatch方法概述:批量删除店铺等级
     * @param ids
     * @return Boolean
     * @创建人 Frunk
     * @创建时间 2019/12/23 17:34
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @ApiOperation("批量删除店铺等级")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "ids", value = "店铺等级IDs", required = true)
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = Result.DELETE_SHOP_GRADE_MSG),
            @ApiResponse(code = 500, message = Result.DELETE_SHOP_GRADE_MSG_ERROR)
    })
    @RequestMapping(value = "/delete-batch", method = RequestMethod.DELETE)
    public Result<Boolean> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        // 定义实体类的数据库查询对象
        Result<Boolean> result = new Result<Boolean>();
        try {
            shopGradeService.removeByIds(Arrays.asList(ids.split(CommonConstant.SEPARATOR)));
        } catch (ForbesException e) {
            result.setBizCode(e.getErrorCode());
            result.setMessage(e.getErrorMsg());
        }
        return result;
    }

    /***
     * receShopGradeStaus方法概述:
     * @return
     * @创建人 Frunk
     * @创建时间 2019/12/23 18:07
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/grade-status", method = RequestMethod.GET)
    @ApiOperation("获取等级枚举值")
    public Result<List<Map<String, String>>> receShopGradeStaus() {
        Result<List<Map<String, String>>> result = new Result<List<Map<String, String>>>();
        result.setResult(ShopGradeEnum.receShopGradeStaus());
        return result;
    }

}
