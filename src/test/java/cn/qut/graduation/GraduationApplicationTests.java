package cn.qut.graduation;

import cn.qut.graduation.dao.StudentDao;
import cn.qut.graduation.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class GraduationApplicationTests {
    @Autowired
    private StudentDao dao;

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
}
