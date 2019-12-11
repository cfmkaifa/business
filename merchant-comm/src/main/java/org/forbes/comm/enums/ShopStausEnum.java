package org.forbes.comm.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import com.google.common.collect.Maps;
/***
 * UserStausEnum概要说明：用户状态
 * @author Huanghy
 */
public enum ShopStausEnum {

    UNAUDITED("0","未审核"),
    INAUDIT("1","审核中"),
    AUDITPASS("2","审核通过"),
    AUDITNOTPASS("3","审核不通过"),
    NORMAL("4","正常"),
    FREEZE("5","冻结");

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
    public static boolean existsShopStausEnum(String code){
        return Arrays.asList(ShopStausEnum.values()).stream()
                .filter(shopStaus -> ((ShopStausEnum)shopStaus).getCode().equals(code)).count() > 0 ;
    }


    /***
     * receUserStaus方法慨述:
     * @return List<Map<String,String>>
     * @创建人 huanghy
     * @创建时间 2019年12月7日 上午11:22:07
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    public static List<Map<String,String>> receUserStaus(){
        return Arrays.asList(ShopStausEnum.values()).stream().map(shopStaus -> {
            Map<String,String> reponseMap = Maps.newHashMap();
            ShopStausEnum shoptStaus = ((ShopStausEnum)shopStaus);
            reponseMap.put("code", shoptStaus.getCode());
            reponseMap.put("name", shoptStaus.getName());
            return reponseMap;
        }).collect(Collectors.toList());
    }

    /***
     *
     * 构造函数:
     * @param code
     * @param name
     */
    ShopStausEnum(String code, String name){
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
