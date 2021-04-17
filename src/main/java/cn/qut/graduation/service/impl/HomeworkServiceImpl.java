package cn.qut.graduation.service.impl;

import cn.qut.graduation.dao.HomeworkDao;
import cn.qut.graduation.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    @Autowired
    private HomeworkDao homeworkDao;
}
