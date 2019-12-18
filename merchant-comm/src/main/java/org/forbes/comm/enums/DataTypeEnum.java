package org.forbes.comm.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Maps;

public enum DataTypeEnum {

	
	ID_CARD("0","商家身份证"),
	CORP_ID_CARD("1","法人身份证"),
	TRADING_CERTIFICATE("2","营业执照");

    /***编码
     */
    private String code;

    /***名称
     */
    private String name;


    /****
     * existsCode方法慨述:判断编码是否存在
     * @param code
     * @return boolean
     * @创建人 huanghy
     * @创建时间 2019年12月16日 下午12:00:56
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    public static boolean existsCode(String code){
        return Arrays.asList(DataTypeEnum.values()).stream()
                .filter(tEnum -> tEnum.getCode().equals(code)).count() > 0 ;
    }


    /***
     * receEnums方法慨述:获取附件类型
     * @return List<Map<String,String>>
     * @创建人 huanghy
     * @创建时间 2019年12月16日 下午12:00:43
     * @修改人 (修改了该文件，请填上修改人的名字)
     * @修改日期 (请填上修改该文件时的日期)
     */
    public static List<Map<String,String>> receEnums(){
        return Arrays.asList(DataTypeEnum.values()).stream().map(tEnum -> {
            Map<String,String> reponseMap = Maps.newHashMap();
            reponseMap.put("code", tEnum.getCode());
            reponseMap.put("name", tEnum.getName());
            return reponseMap;
        }).collect(Collectors.toList());
    }

    /***
     *
     * 构造函数:
     * @param code
     * @param name
     */
    DataTypeEnum(String code, String name){
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
