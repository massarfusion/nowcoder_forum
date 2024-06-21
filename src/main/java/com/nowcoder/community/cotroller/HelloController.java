package com.nowcoder.community.cotroller;

import com.nowcoder.community.service.AlphaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    AlphaService alphaService;

    @GetMapping("/jack")
    @ResponseBody
    public String jack(){
        return "Hello , Jack!";
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        // 拿到请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration <String> enu = request.getHeaderNames();
        while(enu.hasMoreElements()){
            System.out.println(enu.nextElement());
            System.out.println(request.getHeader(enu.nextElement()));
        }
        System.out.println(request.getParameter("code"));

        // 返回响应数据
        response.setContentType("text/html;charset=UTF-8");

        try(PrintWriter writer = response.getWriter();) {
            writer.write("<h1>你好啊</h1>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }

    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public  String getStudents(@RequestParam(name = "current", required = false, defaultValue = "1") int current,
                               @RequestParam(name = "limit", required = false, defaultValue = "1") int limit){
        return "some students "+current+" "+limit;
    }

    @RequestMapping(path = "/students/{sid}", method = RequestMethod.GET)
    @ResponseBody
    public  String getStudents2(@PathVariable(name = "sid")String myID ){
        return "some students with id:"+myID;
    }

    @RequestMapping(path = "/student" , method = RequestMethod.POST)
    @ResponseBody
    public  String insertStudents(String name, int age ){
        return "success!";
    }

    // 响应HTML页面！
    @RequestMapping(path = "/teacher" , method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "SAM");
        modelAndView.addObject("age", 35);
        modelAndView.setViewName("/demo/view");// view.html
        return modelAndView;
    }

    // 响应HTML页面！
    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getTeacher2(Model model) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("name", "SAM");
//        modelAndView.addObject("age", 35);
//        modelAndView.setViewName("/demo/view");// view.html
//        return modelAndView;
        model.addAttribute("name", "PKU");
        model.addAttribute("age", 1146);
        return "/demo/view";
    }

    @RequestMapping(path = "/emp" , method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEMP(){
        Map<String, Object>  emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",23);
        emp.put("salary",10000.00);
        return emp;
//{"name":"张三","salary":10000.0,"age":23}
    }

    @RequestMapping(path = "/emps" , method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getEMP2(){
        List< Map<String, Object> >result = new ArrayList<>();

        Map<String, Object>  emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",23);
        emp.put("salary",10000.00);

        result.add(emp);
        return result;

//{"name":"张三","salary":10000.0,"age":23}
    }


}


