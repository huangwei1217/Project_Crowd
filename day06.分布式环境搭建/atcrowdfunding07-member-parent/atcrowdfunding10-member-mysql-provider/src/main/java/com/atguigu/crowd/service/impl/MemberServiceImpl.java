package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.entity.po.MemberPO;
import com.atguigu.crowd.entity.po.MemberPOExample;
import com.atguigu.crowd.mapper.MemberPOMapper;
import com.atguigu.crowd.service.api.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huangwei
 * @description
 * @create 2021-02-21-14:56
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Resource
    private MemberPOMapper memberPOMapper;

    @Override
    public MemberPO getMemberPOByLoginAcct(String loginacct) {

        // 1.创建Example对象
        MemberPOExample example = new MemberPOExample();

        // 2.创建Criteria对象
        MemberPOExample.Criteria criteria = example.createCriteria();

        // 3.封装查询条件
        criteria.andLoginacctEqualTo(loginacct);

        // 4.执行查询
        List<MemberPO> list = memberPOMapper.selectByExample(example);

        // 5.获取结果
        return list.get(0);
    }
}
