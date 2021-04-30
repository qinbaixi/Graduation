package cn.qut.graduation.service.impl;

import cn.qut.graduation.dao.HomeworkDao;
import cn.qut.graduation.pojo.Homework;
import cn.qut.graduation.pojo.HomeworkVo;
import cn.qut.graduation.service.HomeworkService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    private HomeworkDao homeworkDao;

    @Override
    public List<Homework> getHwList() {
        return homeworkDao.findAll();
    }

    @Override
    public List<HomeworkVo> getHwVoList(Integer sid) {
        List<Homework> all = homeworkDao.findAll();
        List<HomeworkVo> homeworkVoList = new ArrayList<>(all.size());
        for (Homework h : all
        ) {
            HomeworkVo homeworkVo = new HomeworkVo();
            BeanUtils.copyProperties(h, homeworkVo);
            homeworkVo.setCommitBranch(sid * 10 + h.getId());
            homeworkVoList.add(homeworkVo);
        }

        return homeworkVoList;
    }


}
