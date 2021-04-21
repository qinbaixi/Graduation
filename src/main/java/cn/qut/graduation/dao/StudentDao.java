package cn.qut.graduation.dao;

import cn.qut.graduation.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository(value = "studentDao")
public interface StudentDao extends JpaRepository<Student,Integer> {

    @Query(nativeQuery = true,value = "select pwd from student where id=?1")
    String queryPwdById( Integer id);
}
