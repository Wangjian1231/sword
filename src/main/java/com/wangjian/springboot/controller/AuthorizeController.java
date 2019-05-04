package com.wangjian.springboot.controller;

import com.wangjian.springboot.dto.AccessTokenDTO;
import com.wangjian.springboot.dto.GithubUser;
import com.wangjian.springboot.provider.GithubProvider;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName:AuthorizeController
 * Package:com.wangjian.springboot.controller
 * Description:
 *
 * @date:2019/5/4 17:32
 * @author:983998427@qq.com
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                                   HttpServletRequest request){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        if(user !=null){
            request.getSession().setAttribute("user",user);
            //登录成功   写cookie 和session
            return "redirect:/";
        }else{
            //登录失败 重新登录
            return "redirect:/";
        }

    }
}
