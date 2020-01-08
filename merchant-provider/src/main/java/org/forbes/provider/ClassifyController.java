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
import org.forbes.comm.model.ClassifyDto;
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
@RequestMapping("/type")
@Api(tags = {"经营分类管理"})
@Slf4j
public class ClassifyController {

    @Autowired
    IClassifyService classifyService;
    @Autowired
    IShopClassifyService shopClassifyService;


    /***
     * selectPage方法概述:分页查询经营分类
     * @param basePageDto, classifyDto
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
    public Result<IPage<Classify>> selectPage(BasePageDto basePageDto, ClassifyDto classifyDto) {
        Result<IPage<Classify>> result = new Result<>();
        QueryWrapper<Classify> qw = new QueryWrapper<Classify>();
        if (ConvertUtils.isNotEmpty(classifyDto)) {
            if (ConvertUtils.isNotEmpty(classifyDto.getClassifyName())) {
                qw.like(ClassifyConstant.CLASSIFY_NAME, classifyDto.getClassifyName());
            }
        }
        IPage<Classify> page = new Page<Classify>(basePageDto.getPageNo(), basePageDto.getPageSize());
        IPage<Classify> shopPage = classifyService.page(page, qw);
        result.setResult(shopPage);
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
        String code = classify.getCode();
        //查询是否和其他分类编码一致
        int existsCount = classifyService.count(new QueryWrapper<Classify>().eq(DataColumnConstant.CODE, code));
        if (existsCount > 0) {
            result.setBizCode(BizResultEnum.CLASSIFY_CODE_EXISTS.getBizCode());
            result.success(String.format(BizResultEnum.CLASSIFY_CODE_EXISTS.getBizFormateMessage(), code));
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
        if (ConvertUtils.isEmpty(old)) {
            result.setBizCode(BizResultEnum.ENTITY_EMPTY.getBizCode());
            result.setMessage(BizResultEnum.ENTITY_EMPTY.getBizMessage());
            return result;
        }
        //判断当前分类编码与输入的是否一致
        if (!old.getCode().equals(classify.getCode())) {
            String code = classify.getCode();
            //查询是否和其他分类编码一致
            int existsCount = classifyService.count(new QueryWrapper<Classify>().eq(DataColumnConstant.CODE, code));
            if (existsCount > 0) {
                result.setBizCode(BizResultEnum.CLASSIFY_CODE_EXISTS.getBizCode());
                result.success(String.format(BizResultEnum.CLASSIFY_CODE_EXISTS.getBizFormateMessage(), code));
                return result;
            }
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
