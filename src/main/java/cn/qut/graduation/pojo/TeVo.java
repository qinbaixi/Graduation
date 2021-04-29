package cn.qut.graduation.pojo;

/**
 * Teacher业务扩展类
 */
public class TeVo {
    private Integer tid;
    private Integer pwd;

    @Override
    public String toString() {
        return "TeVo{" +
                "tid=" + tid +
                ", pwd=" + pwd +
                '}';
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getPwd() {
        return pwd;
    }

    public void setPwd(Integer pwd) {
        this.pwd = pwd;
    }
}
