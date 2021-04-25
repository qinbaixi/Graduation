package cn.qut.graduation;

import cn.qut.graduation.dao.StudentDao;
import cn.qut.graduation.pojo.HCommit;
import cn.qut.graduation.pojo.Homework;
import cn.qut.graduation.pojo.IdExtension;
import cn.qut.graduation.pojo.Student;
import cn.qut.graduation.service.HCommitService;
import cn.qut.graduation.service.HomeworkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class GraduationApplicationTests {
    @Autowired
    private StudentDao dao;
    @Autowired
    HCommitService hCommitService;
    @Autowired
    private HomeworkService homeworkService;

    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    void testDao() {
        Student one = dao.getOne(1);
        String s = one.toString();
        System.out.println(s);

    }

    @Test
    @Transactional
    void testDao1() {
        String strings = dao.queryPwdById(1);
        System.out.println(strings.toString());
    }

    @Test
    @Transactional
    void testDao2() {
        List<Homework> hwList = homeworkService.getHwList();
        for (int i = 0; i < hwList.size(); i++) {
            System.out.println(hwList.get(i).toString());
        }
    }


}
