package cn.qut.graduation.service.impl;

import cn.qut.graduation.dao.TeacherDao;
import cn.qut.graduation.pojo.TeVo;
import cn.qut.graduation.pojo.Teacher;
import cn.qut.graduation.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> getAll() {
        return teacherDao.findAll();
    }

    @Override
    public boolean check(TeVo teVo) {
        Integer pwd = this.teacherDao.queryPwdByTid(teVo.getTid());
        if (teVo.getPwd().equals(pwd)) {
            return true;
        }
        return false;
    }

    @Override
    public String getNameByTid(Integer tid) {
        return teacherDao.getNameByTid(tid);
    }
}
