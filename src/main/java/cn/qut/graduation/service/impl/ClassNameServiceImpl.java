package cn.qut.graduation.service.impl;

import cn.qut.graduation.dao.ClassNameDao;
import cn.qut.graduation.service.ClassNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassNameServiceImpl implements ClassNameService {
    @Autowired
    private ClassNameDao classNameDao;
}
