package org.forbes.comm.enums;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum ShopRegEnum {

    NAME("0","名称"),
    PICTURE("1","图片"),
    BUSINESS_LICENSE("2","营业执照"),
    BUSINESS_LICENSE_PICTURE("3","营业执照图片"),
    LEGAL_PERSON_NAME("4","法人姓名"),
    LEGAL_PERSON_CARD_ID("5","法人身份证"),
    LEGAL_PERSON_CARD_ID_PICTURE("6","法人身份证图片"),
    ORGANIZATION_CODE("7","组织机构代码"),
    ORGANIZATION_CODE_PICTURE("8","组织机构代码证图片"),
    TAXPAYER_IDENTIFICATION_NUMBER("9","纳税人识别号"),
    TEXT("10","文本"),
    TAX_REGISTRATION_CERTIFICATE_PICTURE("11","税务登记证图片"),
    BANK_ACCOUNT_NAME("12","银行开户名"),
    COMPANY_BANK_ACCOUNT("13","公司银行账号"),
    PHONE("14","电话"),
    ADRESS("15","地址"),
    ZIP_CODE("16","邮编");

    /***编码
     */
    private String code;

    /***名称
     */
    private String name;


    /***
     * existsUserStausEnum方法慨述:
     * @param code
     * @return boolean
     * @创建人 huanghy
     * @创建时间 2019年12月7日 上午11:19:13
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    public static boolean existsShopRegEnum(String code){
        return Arrays.asList(ShopRegEnum.values()).stream()
                .filter(shopReg -> ((ShopRegEnum)shopReg).getCode().equals(code)).count() > 0 ;
    }


    /***
     * receUserStaus方法慨述:
     * @return List<Map<String,String>>
     * @创建人 huanghy
     * @创建时间 2019年12月7日 上午11:22:07
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    public static List<Map<String,String>> receShopGradeStaus(){
        return Arrays.asList(ShopRegEnum.values()).stream().map(shopRegs -> {
            Map<String,String> reponseMap = Maps.newHashMap();
            ShopRegEnum shopReg = ((ShopRegEnum)shopRegs);
            reponseMap.put("code", shopReg.getCode());
            reponseMap.put("name", shopReg.getName());
            return reponseMap;
        }).collect(Collectors.toList());
    }

    /***
     *
     * 构造函数:
     * @param code
     * @param name
     */
    ShopRegEnum(String code, String name){
        this.code = code;
        this.name = name;
    }




    /**
     * @return code
     */
    public String getCode() {
        return code;
    }


    /**
     * @param code 要设置的 code
     */
    public void setCode(String code) {
        this.code = code;
    }


    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 要设置的 name
     */
    public void setName(String name) {
        this.name = name;
    }


}
