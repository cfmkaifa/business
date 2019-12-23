package org.forbes.servcie;

import org.forbes.comm.model.RemoteSysUserDto;
import org.forbes.comm.model.SysRole;
import org.forbes.comm.model.SysUser;
import org.forbes.comm.vo.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/***
 * ISysUserService概要说明：用户外部接口
 * @author Huanghy
 */
public interface ISysUserService {


	/***
	 * registerUser方法慨述:
	 * @param sysUser
	 * @param roleCode
	 * @return Result<RemoteSysUserDto>
	 * @创建人 huanghy
	 * @创建时间 2019年12月16日 上午9:28:49
	 * @修改人 (修改了该文件，请填上修改人的名字)
	 * @修改日期 (请填上修改该文件时的日期)
	 */
	public Result<RemoteSysUserDto> registerUser(RemoteSysUserDto sysUser, String roleCode);

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
	@RequestMapping(value = "/user/get-role-list/{userId}", method = RequestMethod.GET)
	List<SysRole> selectRoleByUserId(@PathVariable Long userId);

}
