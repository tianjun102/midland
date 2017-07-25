package com.huixin.web.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.core.generic.GenericService;
import com.huixin.web.model.AuthRelation;
import com.huixin.web.model.Permission;
import com.huixin.web.model.Role;
import com.huixin.web.model.RoleAuth;
import com.huixin.web.model.RolePermission;

/**
 * 角色 业务接口
 * 
 * @author 
 * @since 2016年6月10日 下午4:15:01
 **/
public interface RoleService extends GenericService<Role, Integer> {
    /**
     * 通过用户id 查询用户 拥有的角色
     * 
     * @param userId
     * @return
     */
    List<Role> selectRolesByUserId(Integer userId);

	List<Role> selectRoleList(Role role);

	/**
	 * 分页搜索查询
	 * @param role
	 * @param pageBounds
	 * @return
	 */
	PageList<Role> selectByExampleAndPage(Role role, PageBounds pageBounds);

	/**
	 * 条件查询获取对象
	 * @param role
	 * @return
	 */
	Role selectByExampleOne(Role role);

	List<RoleAuth> getListAuthid(RoleAuth roleAuth);

	List<AuthRelation> getAuths();

	List<RolePermission> getListPermission(RolePermission rp);

	List<Permission> getPermissions();

	int saveRolePermissions(String roleId, String permissionIds);

	int updateRoleUser(Integer roleId, String userIds);
	
	int modifyRole(Role role);

}
