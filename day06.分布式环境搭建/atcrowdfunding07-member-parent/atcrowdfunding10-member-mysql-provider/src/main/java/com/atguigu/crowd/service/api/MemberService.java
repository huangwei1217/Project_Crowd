package com.atguigu.crowd.service.api;

import com.atguigu.crowd.entity.po.MemberPO;

/**
 * @author huangwei
 * @description
 * @create 2021-02-21-14:55
 */
public interface MemberService {

    MemberPO getMemberPOByLoginAcct(String loginacct);
}
