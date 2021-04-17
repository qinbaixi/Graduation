package cn.qut.graduation.dao;

import cn.qut.graduation.pojo.HCommit;
import cn.qut.graduation.pojo.IdExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HCommitDao extends JpaRepository<HCommit, IdExtension> {
}
