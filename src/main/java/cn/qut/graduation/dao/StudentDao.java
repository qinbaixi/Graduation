package cn.qut.graduation.dao;

import cn.qut.graduation.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "studentDao")
public interface StudentDao extends JpaRepository<Student,Integer> {

    @Query(nativeQuery = true,value = "select pwd from student where id=?1")
    String queryPwdById( Integer id);


    @Query(nativeQuery = true,value = "select pwd from student where sid=?1")
    String queryPwdBySid( Integer id);

    @Query
    Student findBySid(Integer sid);

    @Query(nativeQuery = true,value = "select name from student where sid =?1")
    String getNameBySid(Integer sid);

    @Query(nativeQuery = true,value = "select id from student where sid=?1")
    Integer getIdBySid(Integer sid);

}
