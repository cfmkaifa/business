package org.forbes.comm.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Maps;

/***
 * AdminFlagEnum概要说明：管理员标识
 * @author Huanghy
 */
public enum AdminFlagEnum {

	
	SUPER_ADMIN("0","超级管理员"),
	ORDINARY("1","普通人员");
	
	private String code;
	private String name;
	
	
	
	/***
	 * existsAdminFlag方法慨述:
	 * @param code
	 * @return boolean
	 * @创建人 huanghy
	 * @创建时间 2019年12月10日 上午10:17:17
	 * @修改人 (修改了该文件，请填上修改人的名字)
	 * @修改日期 (请填上修改该文件时的日期)
	 */
	public static boolean existsCode(String code){
		return Arrays.asList(AdminFlagEnum.values()).stream()
		.filter(tEnum -> tEnum.getCode().equals(code)).count() > 0 ;
	}
	
	
	/***
	 * receEnums方法慨述:
	 * @return List<Map<String,String>>
	 * @创建人 huanghy
	 * @创建时间 2019年12月10日 上午10:18:04
	 * @修改人 (修改了该文件，请填上修改人的名字)
	 * @修改日期 (请填上修改该文件时的日期)
	 */
	public static List<Map<String,String>> receEnums(){
		return Arrays.asList(AdminFlagEnum.values()).stream().map(tEnum -> {
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
	AdminFlagEnum(String code,String name){
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
	 * @return name 
	 */
	public String getName() {
		return name;
	}
}
