package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.mapper.RoleMapper;
import com.atguigu.crowd.service.api.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import entity.Admin;
import entity.Role;
import entity.RoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author huangwei
 * @description
 * @create 2021-02-18-22:18
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    // 保存
    @Override
    public void saveRole(Role role) {
        roleMapper.insert(role);
    }

    // 更新
    @Override
    public void updateRole(Role role) {
        roleMapper.updateByPrimaryKey(role);
    }

    // 删除
    @Override
    public void removeRole(List<Integer> roleIdList) {

        RoleExample example = new RoleExample();

        RoleExample.Criteria criteria = example.createCriteria();

        //delete from t_role where id in (5,8,12)
        criteria.andIdIn(roleIdList);

        roleMapper.deleteByExample(example);
    }

    // 分页
    @Override
    public PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize,String keyword) {

        // 1.调用PageHelper的静态方法开启分页功能
        // 这里充分体现了PageHelper的“非侵入式”设计：原本要做的查询不必有任何修改
        PageHelper.startPage(pageNum, pageSize);

        // 2.执行查询
        List<Role> list = roleMapper.selectRoleByKeyword(keyword);

        // 3.封装到PageInfo对象中
        return new PageInfo<>(list);
    }
}
