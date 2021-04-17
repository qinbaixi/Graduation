package cn.qut.graduation.dao;

import cn.qut.graduation.pojo.ClassName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassNameDao extends JpaRepository<ClassName,Integer> {
}
