package cn.tanjianff.contorller;

import cn.tanjianff.Spittr.album.AlbumService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tanjian on 16/9/14.
 * 首页控制器
 */
@ComponentScan
@Controller
@RequestMapping(value = "")
public class HomeController {
    private ClassPathXmlApplicationContext context;

    public HomeController() {
        try {
            this.context = new ClassPathXmlApplicationContext(new String[]{"dubbo-Spittr-consumer-web.xml"});
        }catch (Exception e){
            System.err.println("xml加载失败!"+e);
        }
    }

    private void startContext(){
        this.context.start();
    }

    private AlbumService albumService;

      @RequestMapping(value = "/")
        public String index(){
            return "index";
        }
   /* @RequestMapping(value = "/")
    @ResponseBody
    public List<Album> index() {
        startContext();
        AlbumService albumService = (AlbumService) context.getBean("albumService"); // 获取远程服务代理
        return albumService.getAlbums();
    }*/
}
