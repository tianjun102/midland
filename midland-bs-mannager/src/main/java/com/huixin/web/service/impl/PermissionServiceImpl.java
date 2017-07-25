package com.huixin.web.service.impl;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.huixin.core.generic.GenericDao;
import com.huixin.core.generic.GenericServiceImpl;
import com.huixin.web.dao.PermissionMapper;
import com.huixin.web.model.Permission;
import com.huixin.web.service.PermissionService;

/**
 * 权限Service实现类
 *
 * @author 
 * @since 2016年6月10日 下午12:05:03
 */
@Service
public class PermissionServiceImpl extends GenericServiceImpl<Permission, Integer> implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;


    @Override
    public GenericDao<Permission, Integer> getDao() {
        return permissionMapper;
    }

    @Override
    public List<Permission> selectPermissionsByRoleId(Integer roleId) {
        return permissionMapper.selectPermissionsByRoleId(roleId);
    }
}
