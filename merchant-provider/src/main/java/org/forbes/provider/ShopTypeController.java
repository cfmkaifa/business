package org.forbes.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.forbes.biz.IShopTypeService;
import org.forbes.comm.constant.*;
import org.forbes.comm.enums.BizResultEnum;
import org.forbes.comm.enums.ShopGradeEnum;
import org.forbes.comm.exception.ForbesException;
import org.forbes.comm.model.BasePageDto;
import org.forbes.comm.model.ShopGradeDto;
import org.forbes.comm.model.ShopTypeDto;
import org.forbes.comm.utils.ConvertUtils;
import org.forbes.comm.vo.Result;
import org.forbes.dal.entity.ShopGrade;
import org.forbes.dal.entity.ShopType;
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
@Api(tags={"店铺分类管理"})
@Slf4j
public class ShopTypeController {

    @Autowired
    IShopTypeService shopTypeService;

    /***
     * selectPage方法概述:分页查询店铺分类
     * @param basePageDto, shopTypeDto
     * @return org.forbes.comm.vo.Result<com.baomidou.mybatisplus.core.metadata.IPage<org.forbes.dal.entity.ShopType>>
     * @创建人 Tom
     * @创建时间 2019/12/24 15:18
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ApiOperation(value="分页查询店铺分类")
    @ApiResponses(value={
            @ApiResponse(code=500,message= Result.SHOP_GRADE_PAGE_MSG_ERROR),
            @ApiResponse(code=200,message = Result.SHOP_GRADE_PAGE_MSG)
    })
    public Result<IPage<ShopType>> selectPage(BasePageDto basePageDto, ShopTypeDto shopTypeDto){
        Result<IPage<ShopType>> result = new Result<>();
        QueryWrapper<ShopType> qw = new QueryWrapper<ShopType>();
        if (ConvertUtils.isNotEmpty(shopTypeDto)) {
            if(ConvertUtils.isNotEmpty(shopTypeDto.getName()) ){
                qw.like(PermsCommonConstant.NAME,shopTypeDto.getName());
            }
        }
        IPage<ShopType> page = new Page<ShopType>(basePageDto.getPageNo(),basePageDto.getPageSize());
        IPage<ShopType> shopTypeIPage = shopTypeService.page(page,qw);
        result.setResult(shopTypeIPage);
        return result;
    }

    /***
     * addShopType方法概述:增加店铺分类
     * @param shopType
     * @return org.forbes.comm.vo.Result<org.forbes.dal.entity.ShopType>
     * @创建人 Tom
     * @创建时间 2019/12/24 15:22
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("增加店铺分类")
    @ApiResponses(value={
            @ApiResponse(code=500,message= Result.ADD_SHOP_GRADE_MSG_ERROR),
            @ApiResponse(code=200,message = Result.ADD_SHOP_GRADE_MSG)
    })
    public Result<ShopType> addShopType(@RequestBody @Validated(value=SaveValid.class) ShopType shopType){
        Result<ShopType> result=new Result<ShopType>();
        String code = shopType.getCode();
        //查询是否和其他分类编码一致
        int existsCount = shopTypeService.count(new QueryWrapper<ShopType>().eq(DataColumnConstant.CODE, code));
        if(existsCount > 0) {
            result.setBizCode(BizResultEnum.SHOP_CODE_EXISTS.getBizCode());
            result.success(String.format(BizResultEnum.SHOP_CODE_EXISTS.getBizFormateMessage(), code));
            return result;
        }
        shopTypeService.save(shopType);
        result.setResult(shopType);
        return result;
    }

    /***
     * updateShopType方法概述:编辑店铺分类
     * @param shopType
     * @return org.forbes.comm.vo.Result<org.forbes.dal.entity.ShopType>
     * @创建人 Tom
     * @创建时间 2019/12/24 15:29
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @ApiOperation("编辑店铺分类")
    @ApiResponses(value = {
            @ApiResponse(code=200,message = Result.COMM_ACTION_MSG),
            @ApiResponse(code=500,message = Result.COMM_ACTION_ERROR_MSG)
    })
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public  Result<ShopType> updateShopType(@RequestBody @Validated(value=UpdateValid.class) ShopType shopType){
        Result<ShopType> result=new Result<ShopType>();
        ShopType old = shopTypeService.getById(shopType.getId());
        if(ConvertUtils.isEmpty(old)){
            result.setBizCode(BizResultEnum.ENTITY_EMPTY.getBizCode());
            result.setMessage(BizResultEnum.ENTITY_EMPTY.getBizMessage());
            return result;
        }
        //判断当前分类编码与输入的是否一致
        if (!old.getCode().equals(shopType.getCode())) {
            String code = shopType.getCode();
            //查询是否和其他分类编码一致
            int existsCount = shopTypeService.count(new QueryWrapper<ShopType>().eq(DataColumnConstant.CODE, code));
            if(existsCount > 0) {
                result.setBizCode(BizResultEnum.SHOP_CODE_EXISTS.getBizCode());
                result.success(String.format(BizResultEnum.SHOP_CODE_EXISTS.getBizFormateMessage(), code));
                return result;
            }
        }
        shopTypeService.updateById(shopType);
        result.setResult(shopType);
        return result;
    }

    /***
     * delete方法概述:删除店铺分类
     * @param id
     * @return org.forbes.comm.vo.Result<org.forbes.dal.entity.ShopType>
     * @创建人 Tom
     * @创建时间 2019/12/24 15:30
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @ApiOperation("删除店铺分类")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id",value = "店铺分类ID",required = true)
    })
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result<ShopType> delete(@RequestParam(name="id",required=true) String id) {
        Result<ShopType> result = new Result<ShopType>();
        ShopType shopType = shopTypeService.getById(id);
        if(ConvertUtils.isEmpty(shopType)){
            result.setBizCode(BizResultEnum.ENTITY_EMPTY.getBizCode());
            result.setMessage(BizResultEnum.ENTITY_EMPTY.getBizMessage());
            return result;
        }
        shopTypeService.removeById(id);
        return result;
    }

    /***
     * deleteBatch方法概述:
     * @param ids
     * @return org.forbes.comm.vo.Result<java.lang.Boolean>
     * @创建人 Tom
     * @创建时间 2019/12/24 15:31
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @ApiOperation("批量删除店铺分类")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "ids",value = "店铺分类IDs",required = true)
    })
    @RequestMapping(value = "/delete-batch", method = RequestMethod.DELETE)
    public Result<Boolean> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
        // 定义实体类的数据库查询对象
        Result<Boolean> result = new Result<Boolean>();
        try {
            shopTypeService.removeByIds(Arrays.asList(ids.split(CommonConstant.SEPARATOR)));
        }catch(ForbesException e){
            result.setBizCode(e.getErrorCode());
            result.setMessage(e.getErrorMsg());
        }
        return result;
    }


}
