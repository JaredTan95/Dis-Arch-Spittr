package cn.tanjianff.contorller;

import cn.tanjianff.Spittr.user.UserService;
import cn.tanjianff.Spittr.user.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tanjian on 2017/6/20.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static ClassPathXmlApplicationContext context;

    private UserService userService;

    static {
        try {
            context = BootstrapContext.getContext();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("xml加载失败!" + e);
        }
        context.start();
    }

    public UserController() {
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public User login(String name, String pwd) {
        this.userService = (UserService) context.getBean("userService");

        User u,user=null;
        try {
            u= userService.loginVali(name, pwd);
            user.setAccount(u.getAccount());
            user.setId(u.getId());
            user.setNickname(u.getNickname());
        } catch (Exception e) {
            if (e instanceof DataAccessException) {
                System.out.println(e);
            }
        }
        return user;
    }
}
