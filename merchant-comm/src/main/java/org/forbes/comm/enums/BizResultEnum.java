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
    EMPTY("001001000", "参数为空", ""),
    ENTITY_EMPTY("001001001", "对象为空", ""),
    SHOP_STATUS_NO_EXISTS("003001002", "商家状态不存在", "%s对应商家状态不存在"),
    REMOTE_ERROR_MSG("003001003", "远程调用用户注册异常", "远程调用用户注册异常"),
    ATTCH_DATA_TYPE_ERROR_MSG("003001004", "只允许添加商家身份证/法人身份证/营业执照", "只允许添加商家身份证/法人身份证/营业执照"),
    SHOP_EXISTS("003001005", "商家已经注册", "%s:您已是我们的商家"),
    SHOP_PHONE_EXISTS("003001006", "电话已使用", "%s:已使用"),
    EMAIL_EXIST("003001007","邮箱已存在","%s对应邮箱已存在"),
    PHONE_EXIST("003001008","电话已存在","%s对应电话已存在"),
    FAX_EXIST("003001009","传真已存在","%s对应传真已存在"),
    NAME_EXIST("003001010","名称已存在","%s对应名称已存在"),
    CREDIT_EXIST("003001011","社会信用代码已存在","%s对应社会信用代码已存在"),

    /**
     * 经营分类002
     **/
    CLASSIFY_NAME_EXISTS("003002001", "经营分类名称已存在", "%s对应经营分类名称已存在"),
    CLASSIFY_TYPE_ID_EXISTS("003002002", "经营分类下存在其他商家", "%s对应经营分类下存在其他商家"),
    CLASSIFY_NOT_EXISTS("003002003", "经营分类不存在", "%s对应经营分类不存在"),

    /**
     * 商家等级003
     **/
    SHOP_GRADE_NAME_EXISTS("003003001", "等级名称已存在", "%s对应等级名称已存在"),
    SHOP_GRADE_USED("003003002", "等级被使用中", "%s对应等级被使用中"),

    /**
     * 商家注册项004
     **/
    SHOP_REGISTRATION_NAME_EXISTS("003004001","商家注册项名称已存在","%s对应商家注册项名称已存在"),
    SHOP_REGISTRATION_NAME_USED("003004002","商家注册项被使用中","%s对应商家注册项被使用中");


    /**
     * 错误编码业务系统代码+功能编码+错误代码
     **/
    private String bizCode;
    /**
     * 错误描述
     ****/
    private String bizMessage;
    /**
     * 带格式错误描述
     ****/
    private String bizFormateMessage;

    /***
     * 构造函数:
     * @param bizCode
     * @param bizMessage
     * @param bizFormateMessage
     */
    BizResultEnum(String bizCode, String bizMessage, String bizFormateMessage) {
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
