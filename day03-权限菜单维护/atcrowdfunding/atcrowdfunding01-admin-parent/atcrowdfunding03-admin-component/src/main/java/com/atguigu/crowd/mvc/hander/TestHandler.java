package com.atguigu.crowd.mvc.hander;

import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.util.ResultEntity;
import entity.Admin;
import entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author huangwei
 * @description
 * @create 2020-11-04-15:02
 */
@Controller
public class TestHandler {

    @Autowired
    private AdminService adminService;

    private Logger logger = LoggerFactory.getLogger(TestHandler.class);

    @ResponseBody
    @RequestMapping(path = "/send/compose/object.json")
    public ResultEntity<Student> testReceiveComposeObject(@RequestBody Student student) {

        logger.info(student.toString());

        return ResultEntity.successWithData(student);

    }

    @ResponseBody
    @RequestMapping(path = "send/array/three.html")
    public String testReceiveArrayThree(@RequestBody List<Integer> array) {


        for (Integer number : array) {
            logger.info("number=" + number);
        }

        return "success";
    }

    @ResponseBody
    @RequestMapping(path = "send/array/one.html")
    public String testReceiveArrayone(@RequestParam("array[]") List<Integer> array) {

        for (Integer number : array) {
            System.out.println("number=" + number);
        }

        return "success";
    }

    @RequestMapping(path = "/test/ssm.html")
    public String testSsm(ModelMap modelMap) {

        List<Admin> adminList = adminService.getAll();

        modelMap.addAttribute("adminList", adminList);

//        System.out.println(10 / 0);
        String a = null;
        System.out.println(a.length());

        return "target";

    }

}












