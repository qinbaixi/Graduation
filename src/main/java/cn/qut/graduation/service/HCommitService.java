package cn.qut.graduation.service;

import cn.qut.graduation.pojo.HCommit;
import cn.qut.graduation.pojo.IdExtension;

import java.util.List;

public interface HCommitService {

    List<HCommit> getAllById(Integer id);
}
