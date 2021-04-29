package cn.qut.graduation.dao;

import cn.qut.graduation.pojo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDao extends JpaRepository<Teacher,Integer> {

    @Query(nativeQuery = true, value = "select pwd from teacher where tid =?1")
    public Integer queryPwdByTid(Integer tid);

    @Query(nativeQuery = true,value = "select name from teacher where tid=?1")
    String getNameByTid(Integer tid);
}
