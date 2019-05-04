package com.wangjian.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName:HelloController
 * Package:com.wangjian.springboot
 * Description:
 *
 * @date:2019/5/4 11:01
 * @author:983998427@qq.com
 */

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
