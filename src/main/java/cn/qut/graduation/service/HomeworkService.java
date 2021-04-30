package cn.qut.graduation.service;

import cn.qut.graduation.pojo.Homework;
import cn.qut.graduation.pojo.HomeworkVo;

import java.util.List;

public interface HomeworkService {
    List<Homework> getHwList();

    /**
     * 扩展homework对象并添加需提交分支名
     * @param sid 学号
     * @return List<HomeworkVo>
     */
    List<HomeworkVo> getHwVoList(Integer sid);
}
