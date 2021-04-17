package cn.qut.graduation.dao;

import cn.qut.graduation.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "studentDao")
public interface StudentDao extends JpaRepository<Student,Integer> {
}
