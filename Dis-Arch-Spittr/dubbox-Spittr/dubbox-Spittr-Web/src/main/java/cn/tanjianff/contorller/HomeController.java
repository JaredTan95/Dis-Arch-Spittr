package cn.tanjianff.contorller;

import cn.tanjianff.Spittr.user.UserService;
import cn.tanjianff.Spittr.user.domain.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanjian on 16/9/14.
 * 首页控制器
 */
@ComponentScan
@Controller
@RequestMapping(value = "/")
public class HomeController {
    private static ClassPathXmlApplicationContext context;
    private UserService userService;

    static {
        try {
            context = BootstrapContext.getContext();
        } catch (Exception e) {
            System.err.println("xml加载失败!" + e);
        }
        context.start();
    }

    public HomeController() {
        // 获取远程服务代理
        this.userService = (UserService) context.getBean("userService");
    }

    @RequestMapping(value = "")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "test")
    @ResponseBody
    public List<User> test() {

        List<User> lists = new ArrayList<>();
        if (userService != null) {
            lists.addAll(userService.getUsers());
        } else {
            lists.add(new User());
        }
        return lists;
    }


}
