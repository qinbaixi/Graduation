package cn.qut.graduation.service;

import cn.qut.graduation.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStuByIdAndPwd(Integer id);

    List<Student> getAllStudentsandPwd();


    boolean check(Integer sid, Integer pwd);

    Student getStuBySid(Integer sid);

    String getNameBySid(Integer sid);

    Integer getIdBySid(Integer sid);
}
