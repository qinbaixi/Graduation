package cn.qut.graduation.service.impl;

import cn.qut.graduation.dao.TeacherDao;
import cn.qut.graduation.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;
}
