package cn.qut.graduation.dao;

import cn.qut.graduation.pojo.ClassName;
import cn.qut.graduation.pojo.HCommit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassNameDao extends JpaRepository<ClassName,Integer> {


}
