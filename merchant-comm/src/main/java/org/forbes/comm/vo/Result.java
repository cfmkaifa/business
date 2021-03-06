package org.forbes.comm.vo;

import lombok.Data;
import org.forbes.comm.constant.CommonConstant;

import java.io.Serializable;

/***
 * Result概要说明：统一返回错误
 * @author Huanghy
 */
@Data
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 成功标志
	 */
	private boolean success = true;

	/**
	 * 返回处理消息
	 */
	private String message = "操作成功！";
	/******登录相关提示信息****/

	/*****公共操作结果信息*****/
	public static final  String COMM_ACTION_MSG = "操作成功";
	public static final  String COMM_ACTION_ERROR_MSG = "操作失败";

	/*****商家分页查询*****/
	public static final  String BUSINESS_PAGE_MSG = "商家分页查询成功";
	public static final  String BUSINESS_PAGE_MSG_ERROR = "商家分页查询失败";
	public static final  String SELECT_BUSINESS = "查询商家信息成功";
	public static final  String SELECT_ERROR_BUSINESS = "查询商家信息失败";

	/*****店铺等级分页查询*****/
	public static final  String SHOP_GRADE_PAGE_MSG = "店铺等级分页查询成功";
	public static final  String SHOP_GRADE_PAGE_MSG_ERROR = "店铺等级分页查询失败";
	/*****店铺等级添加*****/
	public static final  String ADD_SHOP_GRADE_MSG = "店铺等级添加成功";
	public static final  String ADD_SHOP_GRADE_MSG_ERROR = "店铺等级添加失败";
	/*****店铺等级修改*****/
	public static final  String UPDATE_SHOP_GRADE_MSG = "店铺等级修改成功";
	public static final  String UPDATE_SHOP_GRADE_MSG_ERROR = "店铺等级修改失败";
	/*****店铺等级删除*****/
	public static final  String DELETE_SHOP_GRADE_MSG = "店铺等级删除成功";
	public static final  String DELETE_SHOP_GRADE_MSG_ERROR = "店铺等级删除失败";

	/*****经营分类分页查询*****/
	public static final  String SHOP_TYPE_PAGE_MSG = "经营分类分页查询成功";
	public static final  String SHOP_TYPE_PAGE_MSG_ERROR = "经营分类分页查询失败";
	/*****经营分类添加*****/
	public static final  String ADD_SHOP_TYPE_MSG = "经营分类添加成功";
	public static final  String ADD_SHOP_TYPE_MSG_ERROR = "经营分类添加失败";
	/*****经营分类修改*****/
	public static final  String UPDATE_SHOP_TYPE_MSG = "经营分类修改成功";
	public static final  String UPDATE_SHOP_TYPE_MSG_ERROR = "经营分类修改失败";
	/*****经营分类删除*****/
	public static final  String DELETE_SHOP_TYPE_MSG = "经营分类删除成功";
	public static final  String DELETE_SHOP_TYPE_MSG_ERROR = "经营分类删除失败";


	/*****商家注册项查询*****/
	public static final  String REGISTRATION_ITEM_PAGE_MSG = "商家注册项分页查询成功";
	public static final  String REGISTRATION_ITEM_PAGE_MSG_ERROR = "商家注册项分页查询失败";
	/*****商家注册项添加*****/
	public static final  String ADD_REGISTRATION_ITEM_MSG = "商家注册项添加成功";
	public static final  String ADD_REGISTRATION_ITEM_MSG_ERROR = "商家注册项添加失败";
	/*****商家注册项修改*****/
	public static final  String UPDATE_REGISTRATION_ITEM_MSG = "商家注册项修改成功";
	public static final  String UPDATE_REGISTRATION_ITEM_MSG_ERROR = "商家注册项修改失败";
	/*****商家注册项删除*****/
	public static final  String DELETE_REGISTRATION_ITEM_MSG = "商家注册项删除成功";
	public static final  String DELETE_REGISTRATION_ITEM_MSG_ERROR = "商家注册项删除失败";

	/*****商家预存款*****/
	public static final  String SHOP_DEPOIST_MSG = "商家预存款查询成功";
	public static final  String SHOP_DEPOIST_ERROR_MSG = "商家预存款查失败";

	/*****商家提现分页查询*****/
	public static final  String SHOP_CASH_PAGE_MSG = "店铺等级分页查询成功";
	public static final  String SHOP_CASH_PAGE_MSG_ERROR = "店铺等级分页查询失败";

	/********添加商家提示消息************/
	public static final String SHOP_ADD_MSG="添加商家成功";
	public static final String SHOP_ADD_ERROR_MSG="添加商家失败";

	/**
	 * 返回代码
	 */
	private Integer code = CommonConstant.SC_OK_200;
	private String  bizCode = "0000";
	
	/**
	 * 返回数据对象 data
	 */
	private T result;

	public Result() {
		
	}
	
	/**
	 * 时间戳
	 */
	private long timestamp = System.currentTimeMillis();

	public void error500(String message) {
		this.message = message;
		this.code = CommonConstant.SC_INTERNAL_SERVER_ERROR_500;
		this.success = false;
	}

	public void success(String message) {
		this.message = message;
		this.code = CommonConstant.SC_OK_200;
		this.success = true;
	}
	
	public static Result<Object> error(String msg) {
		return error(CommonConstant.SC_INTERNAL_SERVER_ERROR_500, msg);
	}
	
	public static Result<Object> error(int code, String msg) {
		Result<Object> r = new Result<Object>();
		r.setCode(code);
		r.setMessage(msg);
		r.setSuccess(false);
		return r;
	}
	
	/***
	 * error方法慨述:
	 * @param bizCode
	 * @param msg
	 * @return Result<Object>
	 * @创建人 huanghy
	 * @创建时间 2019年12月7日 下午4:07:04
	 * @修改人 (修改了该文件，请填上修改人的名字)
	 * @修改日期 (请填上修改该文件时的日期)
	 */
	public  void error(String bizCode, String msg) {
		this.bizCode = bizCode;
		this.message = msg;
		this.success = false;
	}
	
	public static Result<Object> ok(String msg) {
		Result<Object> r = new Result<Object>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setMessage(msg);
		return r;
	}
	
	public static Result<Object> ok(Object data) {
		Result<Object> r = new Result<Object>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setResult(data);
		return r;
	}
}

