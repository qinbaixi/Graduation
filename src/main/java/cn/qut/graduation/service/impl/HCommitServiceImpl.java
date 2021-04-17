package cn.qut.graduation.service.impl;

import cn.qut.graduation.dao.HCommitDao;
import cn.qut.graduation.service.HCcommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HCommitServiceImpl implements HCcommitService {
    @Autowired
    private HCommitDao commitDao;
}
