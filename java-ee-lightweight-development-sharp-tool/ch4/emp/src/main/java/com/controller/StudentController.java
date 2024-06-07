package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.entity.Student;
import com.model.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;//持有一个业务层对象

    @RequestMapping("/findall")
    public String findAll(Model model) {
        List<Student> list = service.findAll();
        model.addAttribute("studentlist", list);
        return "studentlist";
    }

    //Ajax根据ID查询数据
    @ResponseBody
    @RequestMapping("/findInfoById")
    public Object findInfoById(@RequestParam("id") int id) {
    	Student stu = service.findInfoById(id);
    	//String test = JsonUtil.toJson(stu);
        return stu;
    }
}