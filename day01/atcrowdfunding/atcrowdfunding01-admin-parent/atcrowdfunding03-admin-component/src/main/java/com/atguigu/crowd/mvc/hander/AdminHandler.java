package com.atguigu.crowd.mvc.hander;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.service.api.AdminService;
import entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author huangwei
 * @description
 * @create 2021-02-17-22:35
 */
@Controller
public class AdminHandler {

    @Autowired
    private AdminService adminService;

    // 退出登录
    @RequestMapping(path = "/admin/do/logout.html")
    public String doLoginout(HttpSession session){
        // 强制session域失效
        session.invalidate();

        // 返回登录页面
        return "redirect:/admin/to/login/page.html";
    }
    // 登录
    @RequestMapping(path = "/admin/do/login.html")
    public String doLogin(@RequestParam("loginAcct") String loginAcct,
                          @RequestParam("userPswd") String userPswd,
                          HttpSession session){
        // 调用Service方法执行登录检查
        // 这个方法如果能够返回admin对象说明登录成功，如果账号、密码不正确则会抛出异常
        Admin admin = adminService.getAdminByLoginAcct(loginAcct, userPswd);

        // 将登录成功返回的admin对象存入Session域
        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN, admin);

        return "redirect:/admin/to/main/page.html";
    }
}
