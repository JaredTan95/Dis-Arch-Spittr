package cn.tanjianff.contorller;

import cn.tanjianff.Spittr.album.AlbumServiceProvider;
import cn.tanjianff.Spittr.album.domain.Album;
import cn.tanjianff.Spittr.album.repository.JdbcTemplate.JdbcAlbumsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by tanjian on 16/9/14.
 * 首页控制器
 */
@ComponentScan
@Controller
@RequestMapping(value = "")
public class HomeController {

    /*自动注入基于JdbcTemplate实现AlbumsRepository接口的实例Bean,
    * 将其传递给专辑服务提供者*/
    @Autowired
    private JdbcAlbumsRepository jdbcAlbumsRepository;

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/get",method =GET)
    @ResponseBody
    public List<Album> get(){
        return new AlbumServiceProvider(jdbcAlbumsRepository).getAlbums();
    }
}
