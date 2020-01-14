package org.forbes.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.forbes.biz.IShopClassifyService;
import org.forbes.biz.IClassifyService;
import org.forbes.comm.constant.*;
import org.forbes.comm.enums.BizResultEnum;
import org.forbes.comm.exception.ForbesException;
import org.forbes.comm.model.BasePageDto;
import org.forbes.comm.model.ClassifyPageDto;
import org.forbes.comm.utils.ConvertUtils;
import org.forbes.comm.vo.Result;
import org.forbes.dal.entity.Classify;
import org.forbes.dal.entity.ShopClassify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @author lzw
 * @date 2019/12/24 15:11
 */
@RestController
@RequestMapping("/classify")
@Api(tags = {"经营分类管理"})
@Slf4j
public class ClassifyController {

    @Autowired
    IClassifyService classifyService;
    @Autowired
    IShopClassifyService shopClassifyService;


    /***
     * selectPage方法概述:分页查询经营分类
     * @param basePageDto, classifyPageDto
     * @return Classify
     * @创建人 Frunk
     * @创建时间 2019/12/24 15:18
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询经营分类")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = Result.SHOP_TYPE_PAGE_MSG_ERROR),
            @ApiResponse(code = 200, message = Result.SHOP_TYPE_PAGE_MSG)
    })
    public Result<IPage<Classify>> selectPage(BasePageDto basePageDto, ClassifyPageDto classifyPageDto) {
        Result<IPage<Classify>> result = new Result<>();
        QueryWrapper<Classify> qw = new QueryWrapper<Classify>();
        if (ConvertUtils.isNotEmpty(classifyPageDto)) {
            if (ConvertUtils.isNotEmpty(classifyPageDto.getClassifyName())) {
                qw.like(ClassifyCommonConstant.CLASSIFY_NAME, classifyPageDto.getClassifyName());
            }
        }
        IPage<Classify> page = new Page<Classify>(basePageDto.getPageNo(), basePageDto.getPageSize());
        IPage<Classify> shopPage = classifyService.page(page, qw);
        result.setResult(shopPage);
        return result;
    }


    /***
     * selectById方法概述:查看经营分类详情
     * @param id
     * @return Classify
     * @创建人 Frunk
     * @创建时间 2019/12/24 15:29
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @ApiOperation("通过id查看经营分类详情")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = Result.SHOP_TYPE_PAGE_MSG_ERROR),
            @ApiResponse(code = 500, message = Result.SHOP_TYPE_PAGE_MSG)
    })
    @RequestMapping(value = "/get-classify-by-id/{id}", method = RequestMethod.GET)
    public Result<Classify> selectById(@PathVariable String id) {
        Result<Classify> result = new Result<Classify>();
        Classify classify = classifyService.getById(id);
        if (ConvertUtils.isEmpty(classify)) {
            result.setBizCode(BizResultEnum.CLASSIFY_NOT_EXISTS.getBizCode());
            result.setMessage(BizResultEnum.CLASSIFY_NOT_EXISTS.getBizFormateMessage());
            return result;
        }
        result.setResult(classify);
        return result;
    }


    /***
     * addClassify方法概述:增加经营分类
     * @param classify
     * @return Classify
     * @创建人 Frunk
     * @创建时间 2019/12/24 15:22
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("增加经营分类")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = Result.ADD_SHOP_TYPE_MSG_ERROR),
            @ApiResponse(code = 200, message = Result.ADD_SHOP_TYPE_MSG)
    })
    public Result<Classify> addClassify(@RequestBody @Validated(value = SaveValid.class) Classify classify) {
        Result<Classify> result = new Result<Classify>();
        //传入对象不能为空判断
        if (ConvertUtils.isEmpty(classify)) {
            result.setBizCode(BizResultEnum.ENTITY_EMPTY.getBizCode());
            result.setMessage(BizResultEnum.ENTITY_EMPTY.getBizFormateMessage());
            return result;
        }
        int nameCount = classifyService.count(new QueryWrapper<Classify>().eq(ClassifyCommonConstant.CLASSIFY_NAME, classify.getClassifyName()));
        //经营分类名称已存在
        if (nameCount > 0) {
            result.setBizCode(BizResultEnum.CLASSIFY_NAME_EXISTS.getBizCode());
            result.setMessage(BizResultEnum.CLASSIFY_NAME_EXISTS.getBizFormateMessage());
            return result;
        }
        //保证金不能为空判断
        if (ConvertUtils.isEmpty(classify.getBond())) {
            result.setBizCode(BizResultEnum.EMPTY.getBizCode());
            result.setMessage(BizResultEnum.EMPTY.getBizFormateMessage());
            return result;
        }
        classifyService.save(classify);
        result.setResult(classify);
        return result;
    }

    /***
     * updateClassify方法概述:编辑经营分类
     * @param classify
     * @return Classify
     * @创建人 Frunk
     * @创建时间 2019/12/24 15:29
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @ApiOperation("编辑经营分类")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = Result.UPDATE_SHOP_TYPE_MSG_ERROR),
            @ApiResponse(code = 500, message = Result.UPDATE_SHOP_TYPE_MSG_ERROR)
    })
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public Result<Classify> updateClassify(@RequestBody @Validated(value = UpdateValid.class) Classify classify) {
        Result<Classify> result = new Result<Classify>();
        Classify old = classifyService.getById(classify.getId());
        //传入对象不能为空判断
        if (ConvertUtils.isEmpty(old)) {
            result.setBizCode(BizResultEnum.ENTITY_EMPTY.getBizCode());
            result.setMessage(BizResultEnum.ENTITY_EMPTY.getBizMessage());
            return result;
        }
        //保证金不能为空判断
        if (ConvertUtils.isEmpty(classify.getBond())) {
            result.setBizCode(BizResultEnum.EMPTY.getBizCode());
            result.setMessage(BizResultEnum.EMPTY.getBizFormateMessage());
            return result;
        }
        classifyService.updateById(classify);
        result.setResult(classify);
        return result;
    }

    /***
     * delete方法概述:删除经营分类
     * @param id
     * @return Classify
     * @创建人 Frunk
     * @创建时间 2019/12/24 15:30
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @ApiOperation("删除经营分类")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "经营分类ID", required = true)
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = Result.DELETE_SHOP_TYPE_MSG_ERROR),
            @ApiResponse(code = 500, message = Result.DELETE_SHOP_TYPE_MSG_ERROR)
    })
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result<Classify> delete(@RequestParam(name = "id", required = true) String id) {
        Result<Classify> result = new Result<Classify>();
        Classify classify = classifyService.getById(id);
        if (ConvertUtils.isEmpty(classify)) {
            result.setBizCode(BizResultEnum.ENTITY_EMPTY.getBizCode());
            result.setMessage(BizResultEnum.ENTITY_EMPTY.getBizMessage());
            return result;
        }
        //判断该分类下是否还有其他商家
        int shopCount = shopClassifyService.count(new QueryWrapper<ShopClassify>().eq(ShopClassifyCommonConstant.CLASSIFY_ID, id));
        if (shopCount > 0) {
            result.setBizCode(BizResultEnum.CLASSIFY_TYPE_ID_EXISTS.getBizCode());
            result.setMessage(BizResultEnum.CLASSIFY_TYPE_ID_EXISTS.getBizMessage());
            return result;
        }
        classifyService.removeById(id);
        return result;
    }

    /***
     * deleteBatch方法概述:
     * @param ids
     * @return Boolean
     * @创建人 Frunk
     * @创建时间 2019/12/24 15:31
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @ApiOperation("批量删除经营分类")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "ids", value = "经营分类IDs", required = true)
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = Result.DELETE_SHOP_TYPE_MSG_ERROR),
            @ApiResponse(code = 500, message = Result.DELETE_SHOP_TYPE_MSG_ERROR)
    })
    @RequestMapping(value = "/delete-batch", method = RequestMethod.DELETE)
    public Result<Boolean> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        // 定义实体类的数据库查询对象
        Result<Boolean> result = new Result<Boolean>();
        try {
            classifyService.removeByIds(Arrays.asList(ids.split(CommonConstant.SEPARATOR)));
        } catch (ForbesException e) {
            result.setBizCode(e.getErrorCode());
            result.setMessage(e.getErrorMsg());
        }
        return result;
    }


}
