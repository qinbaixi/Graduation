package cn.qut.graduation.service.impl;

import cn.qut.graduation.dao.StudentDao;
import cn.qut.graduation.pojo.Student;
import cn.qut.graduation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }
}
