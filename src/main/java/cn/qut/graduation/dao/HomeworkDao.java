package cn.qut.graduation.dao;

import cn.qut.graduation.pojo.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeworkDao extends JpaRepository<Homework,Integer> {
}
