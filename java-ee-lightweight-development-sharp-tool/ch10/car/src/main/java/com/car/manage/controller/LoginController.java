package com.car.manage.controller;

import com.car.manage.common.constants.Constants;
import com.car.manage.dto.RegisterType;
import com.car.manage.system.entity.User;
import com.car.manage.system.service.UserService;
import com.car.manage.utils.CryptographyUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 登录退出.
 */
@RequestMapping("/car/login")
@Controller
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserService userService;

    @Value("${single.logout.url}")
    private String singleLogout;

    /**
     * index.
     *
     * @return index
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String index() {
        return "/car/login/index";
    }


    /**
     * 登出.
     *
     * @param response response
     * @throws Exception Exception
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String logout(HttpServletResponse response) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
            LOGGER.info("用户退出登录");
        }
        return "redirect:/car/login";
        //response.sendRedirect(singleLogout + "/sys/logout");
    }

    /**
     * @param username username
     * @param password password
     * @return String
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RegisterType login(String username, String password) {
        RegisterType rt = new RegisterType();

        UsernamePasswordToken token = new UsernamePasswordToken(username, CryptographyUtil.md5(password,
                Constants.SALT));
        //获取当前的Subject25553ebdd73835ca5a5bd68ea9d089bc
        // [2111c427fe8c16b0a7be319e537828d7]
        Subject currentUser = SecurityUtils.getSubject();
        //Serializable id = currentUser.getSession().getId();
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            currentUser.login(token);
            User user = userService.findByUsername(token.getUsername());
            if ("driver".equals(user.getSymbol().toString())) {
                rt.setStatus("fail");
                rt.setContent("非管理员禁止登录");
            } else if ("manager".equals(user.getSymbol().toString())) {
                // 保存user信息到session
            	// 修改
                Session session = SecurityUtils.getSubject().getSession();
                session.setAttribute(Constants.SESSION_USER_KEY, user);
                rt.setStatus("success");
                rt.setContent("manager");
            } else {
                rt.setStatus("fail");
                rt.setContent("系统异常，请联系管理员");
            }

        } catch (Exception ae) {
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
            }

            rt.setStatus("fail");
            rt.setContent("用户名或者密码错误，请检查后重新输入");
        }
        //验证是否登录成功
        if (currentUser.isAuthenticated()) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
            }
            //rt.setStatus("success");
            return rt;
        } else {
            token.clear();
            currentUser.logout();
            rt.setStatus("fail");
            return rt;
        }
    }

}
