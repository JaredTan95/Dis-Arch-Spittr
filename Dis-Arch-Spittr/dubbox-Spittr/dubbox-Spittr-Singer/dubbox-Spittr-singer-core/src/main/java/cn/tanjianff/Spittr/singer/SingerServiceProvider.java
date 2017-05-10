package cn.tanjianff.Spittr.singer;

import cn.tanjianff.Spittr.singer.domain.Singer;
import cn.tanjianff.Spittr.singer.repository.SingerRepository;

import java.util.List;

/**
 * Created by tanjian on 2017/5/10.
 */
public class SingerServiceProvider implements SingerService{
    private SingerRepository singerRepository;

    public SingerServiceProvider(SingerRepository singerRepository) {
        this.singerRepository = singerRepository;
    }

    @Override
    public List<Singer> getSingers() {
        return singerRepository.findAll();
    }

    @Override
    public Singer save(Singer singer) {
        return singerRepository.save(singer)?singer:new Singer();
    }

    @Override
    public Singer getById(String id) {
        return singerRepository.findById(id);
    }

    @Override
    public List<Singer> getByName(String name) {
        return singerRepository.findByName(name);
    }
}
