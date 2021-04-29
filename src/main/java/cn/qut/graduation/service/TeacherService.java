package cn.qut.graduation.service;

import cn.qut.graduation.pojo.TeVo;
import cn.qut.graduation.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAll();

    boolean check(TeVo teVo);

    String getNameByTid(Integer tid);
}
