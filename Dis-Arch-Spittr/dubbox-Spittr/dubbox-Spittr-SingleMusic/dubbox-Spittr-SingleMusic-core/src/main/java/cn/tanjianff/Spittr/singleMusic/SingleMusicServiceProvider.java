package cn.tanjianff.Spittr.singleMusic;

import cn.tanjianff.Spittr.singleMusic.domain.SingleMusic;
import cn.tanjianff.Spittr.singleMusic.repository.SingleMusicRepository;

import java.util.List;

/**
 * Created by tanjian on 2017/5/15.
 * 单曲服务提供者
 */
public class SingleMusicServiceProvider implements SingleMusicService {
    private SingleMusicRepository singleMusicRepository;

    public SingleMusicServiceProvider(SingleMusicRepository singleMusicRepository) {
        this.singleMusicRepository = singleMusicRepository;
    }

    @Override
    public List<SingleMusic> getSongs() {
        return singleMusicRepository.findAll();
    }

    @Override
    public SingleMusic save(SingleMusic song) {
        return singleMusicRepository.save(song)?song:new SingleMusic();
    }

    @Override
    public SingleMusic getById(String id) {
        return singleMusicRepository.findById(id);
    }

    @Override
    public List<SingleMusic> getBySingerID(String id) {
        return singleMusicRepository.findBySingerId(id);
    }

    @Override
    public List<SingleMusic> getByTitle(String title) {
        return singleMusicRepository.findByTitle(title);
    }

    @Override
    public List<SingleMusic> getByVisited() {
        return singleMusicRepository.OrderByVisited();
    }

    @Override
    public List<SingleMusic> getByDloaded() {
        return singleMusicRepository.OrderByDloaded();
    }

    @Override
    public List<SingleMusic> getByUpDate() {
        return singleMusicRepository.OrderByUpDate();
    }

    @Override
    public int getMax() {
        return singleMusicRepository.count();
    }
}
