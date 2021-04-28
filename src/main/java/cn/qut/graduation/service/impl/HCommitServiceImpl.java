package cn.qut.graduation.service.impl;

import cn.qut.graduation.dao.HCommitDao;
import cn.qut.graduation.pojo.HCommit;
import cn.qut.graduation.pojo.IdExtension;
import cn.qut.graduation.service.HCommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HCommitServiceImpl implements HCommitService {
    @Autowired
    private HCommitDao commitDao;


    @Override
    public List<HCommit> getAllBySid(Integer id) {
        return commitDao.getAllBySid(id);
    }

    @Override
    public List<HCommit> getAll() {
        return commitDao.findAll();
    }
}
