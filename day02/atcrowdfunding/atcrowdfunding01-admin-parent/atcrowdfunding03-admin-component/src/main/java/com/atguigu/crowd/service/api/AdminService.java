package com.atguigu.crowd.service.api;

import com.github.pagehelper.PageInfo;
import entity.Admin;

import java.util.List;

/**
 * @author huangwei
 * @description
 * @create 2021-01-25-13:43
 */
public interface AdminService {

    void saveAdmin(Admin admin);

    List<Admin> getAll();

    Admin getAdminByLoginAcct(String loginAcct, String userPswd);

    PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize);

    Admin getAdminById(Integer adminId);

    void update(Admin admin);

    void remove(Integer adminId);

//    void saveAdminRoleRelationship(Integer adminId, List<Integer> roleIdList);
//
//    Admin getAdminByLoginAcct(String username);
}
