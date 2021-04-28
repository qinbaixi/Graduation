package cn.qut.graduation.dao;

import cn.qut.graduation.pojo.HCommit;
import cn.qut.graduation.pojo.IdExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HCommitDao extends JpaRepository<HCommit, IdExtension> {
    /**
     * 实际对应sid
     * @param sid
     * @return
     */
    @Query(nativeQuery = true, value = "select * from hcommit where sid =?1")
    List<HCommit> getAllBySid(Integer sid);

}
