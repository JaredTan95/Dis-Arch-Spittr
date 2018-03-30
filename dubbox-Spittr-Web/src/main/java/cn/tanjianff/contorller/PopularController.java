package cn.tanjianff.contorller;

import cn.tanjianff.Spittr.album.AlbumService;
import cn.tanjianff.Spittr.album.domain.Album;
import cn.tanjianff.Spittr.singleMusic.SingleMusicService;
import cn.tanjianff.Spittr.singleMusic.domain.SingleMusic;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by tanjian on 2017/6/15.
 */
@Controller
@RequestMapping(value = "/popular")
public class PopularController {
    private static ClassPathXmlApplicationContext context;
    private SingleMusicService singleMusicService;
    private AlbumService albumService;
    static {
        try {
            context = BootstrapContext.getContext();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("xml加载失败!" + e);
        }
        context.start();
    }

    public PopularController() {
        // 获取远程服务代理
    }


    /**
     * 获取最热专辑.
     *
     * @param lmt 需获取专辑数量
     * @return 专辑集合(List) list
     */
    @RequestMapping(value = "/albums")
    @ResponseBody
    public List<Album> getAlbums(int lmt){
        this.albumService= (AlbumService) context.getBean("albumService");
        return albumService.getByVisited(lmt);
    }

    /**
     * 获取最热单曲
     *
     * @param lmt 需获取单曲数量
     * @return 单曲集合(List)
     */
    @RequestMapping(value = "/singelMusic")
    @ResponseBody
    public List<SingleMusic> getSingleMusic(int lmt){
        this.singleMusicService= (SingleMusicService) context.getBean("singleMusicService");
        return singleMusicService.getByVisited(lmt);
    }
}
