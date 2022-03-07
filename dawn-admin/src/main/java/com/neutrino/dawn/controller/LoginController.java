package com.neutrino.dawn.controller;

import com.dawn.common.basemodel.AjaxResult;
import com.neutrino.dawn.model.SysUser;
import com.neutrino.dawn.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package: com.dawn.controller.system
 * Description:
 * Date:  2020/3/31 17:33
 * Author: kousq
 * Modified By:
 */
@RestController
public class LoginController {

    @Autowired
    private ISysUserService sysUserService;

        public static final Logger log = LoggerFactory.getLogger(LoginController.class);
       @GetMapping("/welcomelogin")
        public String login() {
            System.out.println("welcome!");
            return "login";
        }

        @PostMapping("/login")
        public AjaxResult login(String username, String password, Boolean rememberMe){
            SysUser sysuser = sysUserService.selectUserByLoginName(username);

            if( sysuser.getPassword().equals(password.trim())){

                return AjaxResult.success();
            }
            return AjaxResult.error();
        }
}
