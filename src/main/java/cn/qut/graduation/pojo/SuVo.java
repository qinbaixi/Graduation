package cn.qut.graduation.pojo;

/**
 * 学生工参数类
 */
public class SuVo {
    private Integer sid;

    private Integer pwd;

    @Override
    public String toString() {
        return "SuVo{" +
                "sid=" + sid +
                ", pwd=" + pwd +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getPwd() {
        return pwd;
    }

    public void setPwd(Integer pwd) {
        this.pwd = pwd;
    }
}
