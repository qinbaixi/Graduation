package cn.qut.graduation.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class HomeworkVo {

    private Integer id;


    private String title;

    private String desc;

    private Date rltime;

    private Date delineTime;

    private Integer commitBranch;

    @Override
    public String toString() {
        return "HomeworkVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", rltime=" + rltime +
                ", delineTime=" + delineTime +
                ", commitBranch=" + commitBranch +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getRltime() {
        return rltime;
    }

    public void setRltime(Date rltime) {
        this.rltime = rltime;
    }

    public Date getDelineTime() {
        return delineTime;
    }

    public void setDelineTime(Date delineTime) {
        this.delineTime = delineTime;
    }

    public Integer getCommitBranch() {
        return commitBranch;
    }

    public void setCommitBranch(Integer commitBranch) {
        this.commitBranch = commitBranch;
    }
}

