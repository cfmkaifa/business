package org.forbes.provider;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.forbes.biz.IShopAttachService;
import org.forbes.biz.IShopService;
import org.forbes.comm.constant.DataColumnConstant;
import org.forbes.comm.constant.SaveValid;
import org.forbes.comm.constant.ShopCommonConstant;
import org.forbes.comm.enums.BizResultEnum;
import org.forbes.comm.enums.ShopStausEnum;
import org.forbes.comm.exception.ForbesException;
import org.forbes.comm.model.BasePageDto;
import org.forbes.comm.model.PageShopDto;
import org.forbes.comm.model.SysRole;
import org.forbes.comm.model.SysUser;
import org.forbes.comm.utils.ConvertUtils;
import org.forbes.comm.vo.Result;
import org.forbes.dal.entity.Shop;
import org.forbes.dal.entity.ShopAttach;
import org.forbes.servcie.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Qualifier(value = "shopManagerService")
    IShopService shopService;

    @Autowired
    ISysUserService sysUserService;

    @Autowired
    IShopAttachService shopAttachService;

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
    @ApiOperation("审核冻结商家")
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

    /***
     * getByName方法概述:
     * @param name, phone
     * @return org.forbes.comm.vo.Result<org.forbes.dal.entity.Shop>
     * @创建人 Tom
     * @创建时间 2019/12/23 10:41
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/get-by-name", method = RequestMethod.GET)
    @ApiOperation("通过名字和电话号码查询商家信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id",value = "订单id")
    )
    @ApiResponses(value={
            @ApiResponse(code=500,message= Result.SELECT_ERROR_BUSINESS),
            @ApiResponse(code=200,message = Result.SELECT_BUSINESS)
    })
    public Result<Shop> getByName(@RequestParam(value = "name",required = true)String name,@RequestParam(value = "phone",required = true)String phone){
        Result<Shop> result=new Result<Shop>();
        //查询商家信息
        Shop shop = shopService.getByName(name);
        //根据联系方式查询用户信息
        SysUser sysUser=sysUserService.getUserByName(phone);
        if(ConvertUtils.isNotEmpty(sysUser)){
            shop.setSysUsers(sysUser);
        }
        //根据用户id方式查询角色
        List<SysRole> sysRoles=sysUserService.selectRoleByUserId(sysUser.getId());
        if(ConvertUtils.isNotEmpty(sysRoles)){
            shop.setSysRoles(sysRoles);
        }
        //查询商家附件信息
        List<ShopAttach> shopAttaches = shopAttachService.list(new QueryWrapper<ShopAttach>().eq(DataColumnConstant.NAME,name));
        if(ConvertUtils.isNotEmpty(shopAttaches)){
            shop.setShopAttachs(shopAttaches);
        }
        result.setResult(shop);
        return result;
    }

    /***
     * selectShopList方法概述:分页查询商家
     * @param basePageDto, pageShopDto
     * @return org.forbes.comm.vo.Result<com.baomidou.mybatisplus.core.metadata.IPage<org.forbes.dal.entity.Shop>>
     * @创建人 Tom
     * @创建时间 2019/12/23 13:51
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
            @ApiOperation(value="分页查询商家")
            @ApiResponses(value={
                    @ApiResponse(code=500,message= Result.BUSINESS_PAGE_MSG_ERROR),
            @ApiResponse(code=200,message = Result.BUSINESS_PAGE_MSG)
    })
    public Result<IPage<Shop>> selectShopList(BasePageDto basePageDto,PageShopDto pageShopDto){
        Result<IPage<Shop>> result = new Result<>();
        QueryWrapper<Shop> qw = new QueryWrapper<Shop>();
        if (ConvertUtils.isNotEmpty(pageShopDto)) {
            if(ConvertUtils.isNotEmpty(pageShopDto.getStatus()) ){
                qw.eq(ShopCommonConstant.STATUS,pageShopDto.getStatus());
            }
            if(ConvertUtils.isNotEmpty(pageShopDto.getRoleId()) ){
                qw.eq(ShopCommonConstant.ROLEID,pageShopDto.getRoleId());
            }
            if(ConvertUtils.isNotEmpty(pageShopDto.getName()) ){
                qw.like(ShopCommonConstant.NAME,pageShopDto.getName());
            }
            if(ConvertUtils.isNotEmpty(pageShopDto.getUsername()) ){
                qw.like(ShopCommonConstant.USERNAME,pageShopDto.getUsername());
            }
        }
        IPage<Shop> page = new Page<Shop>(basePageDto.getPageNo(),basePageDto.getPageSize());
        IPage<Shop> shopIPage = shopService.page(page,qw);

        //用户跨库查询分页
//      SysUser sysUser=sysUserService.getUserByName(pageShopDto.getUsername());
        result.setResult(shopIPage);
        return result;
    }


    /**
     * @Author xfx
     * @Date 16:27 2020/1/16
     * @Param [shop]
     * @return org.forbes.dal.entity.Shop
     * 添加发布需求人（智工网）
     **/
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value="添加商家")
    @ApiResponses(value={
            @ApiResponse(code=500,message= Result.SHOP_ADD_ERROR_MSG),
            @ApiResponse(code=200,message = Result.SHOP_ADD_MSG)
    })
    public Result<Shop> add(@RequestBody @Validated(value=SaveValid.class) Shop shop){
        log.debug("================:"+JSON.toJSONString(shop));
        Result<Shop> result=new Result<Shop>();
        try {
            //判断邮箱是否已存在
            String email = shop.getEmail();
            int emailcount=shopService.count(new QueryWrapper<Shop>().eq(DataColumnConstant.EMAIL,email));
            if(emailcount>0){
                result.setBizCode(BizResultEnum.EMAIL_EXIST.getBizCode());
                result.setMessage(String.format(BizResultEnum.EMAIL_EXIST.getBizFormateMessage(),email));
                return result;
            }
            //判断电话是否已存在
            String phone = shop.getFax();
            int phonecount=shopService.count(new QueryWrapper<Shop>().eq(DataColumnConstant.PHONE,phone));
            if(phonecount>0){
                result.setBizCode(BizResultEnum.PHONE_EXIST.getBizCode());
                result.setMessage(String.format(BizResultEnum.PHONE_EXIST.getBizFormateMessage(),phone));
                return result;
            }
            //判断传真是否已存在
            String fax = shop.getEmail();
            int faxcount=shopService.count(new QueryWrapper<Shop>().eq(DataColumnConstant.FAX,fax));
            if(faxcount>0){
                result.setBizCode(BizResultEnum.FAX_EXIST.getBizCode());
                result.setMessage(String.format(BizResultEnum.FAX_EXIST.getBizFormateMessage(),fax));
                return result;
            }
            //判断社会信用代码是否已存在
            String credit = shop.getEmail();
            int creditcount=shopService.count(new QueryWrapper<Shop>().eq(DataColumnConstant.CREDIT,credit));
            if(creditcount>0){
                result.setBizCode(BizResultEnum.CREDIT_EXIST.getBizCode());
                result.setMessage(String.format(BizResultEnum.CREDIT_EXIST.getBizFormateMessage(),credit));
                return result;
            }
            //判断名称是否已存在
            String name = shop.getEmail();
            int namecount=shopService.count(new QueryWrapper<Shop>().eq(DataColumnConstant.NAME,name));
            if(namecount>0){
                result.setBizCode(BizResultEnum.NAME_EXIST.getBizCode());
                result.setMessage(String.format(BizResultEnum.NAME_EXIST.getBizFormateMessage(),name));
                return result;
            }
            shopService.save(shop);
            result.setResult(shop);
        }catch (ForbesException e){
            result.setBizCode(e.getErrorCode());
         	result.setMessage(e.getErrorMsg());
        }
        return result;
    }
}
