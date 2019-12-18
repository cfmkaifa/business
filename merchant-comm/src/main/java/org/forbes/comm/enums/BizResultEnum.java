package org.forbes.comm.enums;
/***
 * BizResultEnum概要说明：业务系统错误代码
 * @author Huanghy
 */
public enum BizResultEnum {
	/***
	 * 001-商家信息
	 * 功能暂无-表示通用异常
	 * 001-为空判断
	 */
	ENTITY_EMPTY("001001000","对象为空",""),
	SHOP_STATUS_NO_EXISTS("003001006","商家状态不存在","%s对应商家状态不存在"),
	REMOTE_ERROR_MSG("003001007","远程调用用户注册异常","远程调用用户注册异常"),
	ATTCH_DATA_TYPE_ERROR_MSG("003001008","只允许添加商家身份证/法人身份证/营业执照","只允许添加商家身份证/法人身份证/营业执照"),
	SHOP_EXISTS("003001009","商家已经注册","%s:您已是我们的商家"),
	SHOP_PHONE_EXISTS("003001010","电话已使用","%s:已使用");

	
	/**错误编码业务系统代码+功能编码+错误代码**/
	private String bizCode;
	/**错误描述****/
	private String bizMessage;
	/**带格式错误描述****/
	private String bizFormateMessage;

	/***
	 * 构造函数:
	 * @param bizCode
	 * @param bizMessage
	 * @param bizFormateMessage
	 */
	BizResultEnum(String bizCode, String bizMessage, String bizFormateMessage){
		this.bizCode = bizCode;
		this.bizMessage = bizMessage;
		this.bizFormateMessage = bizFormateMessage;
	}

	/** 
	 * @return bizCode 
	 */
	public String getBizCode() {
		return bizCode;
	}

	/** 
	 * @param bizCode 要设置的 bizCode 
	 */
	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	/** 
	 * @return bizMessage 
	 */
	public String getBizMessage() {
		return bizMessage;
	}

	/** 
	 * @param bizMessage 要设置的 bizMessage 
	 */
	public void setBizMessage(String bizMessage) {
		this.bizMessage = bizMessage;
	}

	/** 
	 * @return bizFormateMessage 
	 */
	public String getBizFormateMessage() {
		return bizFormateMessage;
	}

	/** 
	 * @param bizFormateMessage 要设置的 bizFormateMessage 
	 */
	public void setBizFormateMessage(String bizFormateMessage) {
		this.bizFormateMessage = bizFormateMessage;
	}
}
