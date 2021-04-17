package cn.qut.graduation.service.impl;

import cn.qut.graduation.dao.StudentDao;
import cn.qut.graduation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
}
