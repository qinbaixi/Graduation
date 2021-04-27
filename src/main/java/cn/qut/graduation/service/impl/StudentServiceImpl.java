package cn.qut.graduation.service.impl;

import cn.qut.graduation.dao.StudentDao;
import cn.qut.graduation.pojo.Student;
import cn.qut.graduation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Transactional
    @Override
    public Student getStuByIdAndPwd(Integer id) {
        Student one = this.studentDao.getOne(id);
        one.setPwd(studentDao.queryPwdById(id));
        System.out.println(one.toString());

        return one;
    }

    @Transactional
    @Override
    public List<Student> getAllStudentsandPwd() {
        List<Student> all = this.studentDao.findAll();
        for (Student s : all
        ) {
            s.setPwd(studentDao.queryPwdById(s.getId()));
        }

        return all;
    }

    @Transactional
    @Override
    public boolean check(Integer sid, Integer pwd) {
        String s = this.studentDao.queryPwdById(sid);
        if (s.equals(pwd)) {
            return true;
        }

        return false;
    }


}
