package org.forbes.servcie;

import org.forbes.comm.model.SysRole;
import org.forbes.comm.model.SysUser;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/***
 * ISysUserService概要说明：用户外部接口
 * @author Huanghy
 */
@ConditionalOnProperty(name="spring.application.usercenter")
@FeignClient(name="${spring.application.usercenter}",url = "http://129.211.88.251:888/usercenter")
public interface ISysUserService {

//
//	/***
//	 * registerUser方法慨述:
//	 * @param sysUser
//	 * @param roleCode
//	 * @return Result<RemoteSysUserDto>
//	 * @创建人 huanghy
//	 * @创建时间 2019年12月16日 上午9:28:49
//	 * @修改人 (修改了该文件，请填上修改人的名字)
//	 * @修改日期 (请填上修改该文件时的日期)
//	 */
//	 Result<RemoteSysUserDto> registerUser(RemoteSysUserDto sysUser, String roleCode);

	/***
	 * 方法概述:根据用户名查询用户信息
	 * @param
	 * @return
	 * @创建人 xfx
	 * @创建时间 2019/12/19
	 * @修改人 (修改了该文件，请填上修改人的名字)
	 * @修改日期 (请填上修改该文件时的日期)
	 */
	@RequestMapping(value = "/user/user-by-name", method = RequestMethod.GET)
	SysUser getUserByName(String username);

	/***
	 * 方法概述:根据用户id查询角色
	 * @param
	 * @return
	 * @创建人 xfx
	 * @创建时间 2019/12/19
	 * @修改人 (修改了该文件，请填上修改人的名字)
	 * @修改日期 (请填上修改该文件时的日期)
	 */
	@RequestMapping(value = "/user/get-role-list", method = RequestMethod.GET)
	List<SysRole> selectRoleByUserId(@RequestParam("userId") Long userId);

}
