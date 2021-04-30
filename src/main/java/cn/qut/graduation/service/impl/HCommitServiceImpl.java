package cn.qut.graduation.service.impl;

import cn.qut.graduation.dao.HCommitDao;
import cn.qut.graduation.dao.StudentDao;
import cn.qut.graduation.pojo.HCommit;
import cn.qut.graduation.pojo.IdExtension;
import cn.qut.graduation.service.HCommitService;
import cn.qut.graduation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HCommitServiceImpl implements HCommitService {
    @Autowired
    private HCommitDao commitDao;
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<HCommit> getAllBySid(Integer id) {
        return commitDao.getAllBySid(id);
    }

    @Override
    public List<HCommit> getAll() {
        return commitDao.findAll();
    }

    @Override
    public void save(HCommit hCommit) {
        Optional<HCommit> byId = this.commitDao.findById(hCommit.getId());
        HCommit old = byId.get();
        old.setScore(hCommit.getScore());
        this.commitDao.save(old);
    }

    /**
     *
     * @param branch
     * @param rpAddr
     * @return
     */
    @Override
    public Boolean updateBranchAndReport(Integer branch, String rpAddr) {
        IdExtension idExtension = new IdExtension();
        Integer suId = studentDao.getIdBySid(branch / 10);

        idExtension.setSid(suId);
        idExtension.setHid(branch % 10);

        Optional<HCommit> byId = commitDao.findById(idExtension);
        HCommit hCommit = byId.get();
        hCommit.setRadress(rpAddr);
        commitDao.save(hCommit);
        return true;
    }
}
