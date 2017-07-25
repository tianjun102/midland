package com.huixin.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.core.generic.GenericDao;
import com.huixin.web.model.User;
import com.huixin.web.model.UserExample;
import com.huixin.web.model.UserRole;

/**
 * 用户Dao接口
 * 
 * @author 
 * @since 2016年7月5日 上午11:49:57
 **/
public interface UserMapper extends GenericDao<User, Integer> {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 用户登录验证查询
     * 
     * @param record
     * @return
     */
    User authentication(@Param("record") User record);

    /**
     * 分页条件查询
     * 
     * @param page
     * @param example
     * @return
     */
    PageList<User> selectByExampleAndPage(UserExample example,PageBounds pageBounds);

    /**
     * 批量新增用户角色关系
     * @param list
     * @return
     */
	int insertUserRoleBatch(List<UserRole> list);

	/**
	 * 查找用户的角色关系
	 * @param userId
	 * @return
	 */
	List<UserRole> findUserRoleByUserId(@Param("userId") Integer userId);

	/**
	 * 批量删除用户角色关系
	 * @param userId
	 * @param list1
	 * @return
	 */
	int deleteUserRoleBatch(@Param("userId") Integer userId, @Param("list") List<UserRole> list);

	List<User> selectUsersByRoleId(Integer roleId);

	int deleteUserRoleBatchById(List<UserRole> list);
	
	User queryUserForCustCode(String custCode);
}