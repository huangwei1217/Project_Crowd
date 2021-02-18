package com.atguigu.crowd.service.api;

import com.github.pagehelper.PageInfo;
import entity.Role;

import java.util.List;

/**
 * @author huangwei
 * @description
 * @create 2021-02-18-22:17
 */
public interface RoleService {

    PageInfo<Role> getPageInfo( Integer pageNum, Integer pageSize,String keyword);

    void saveRole(Role role);

    void updateRole(Role role);

    void removeRole(List<Integer> roleIdList);
}
