package cn.qut.graduation.pojo;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "homework")
public class Homework implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "title")
    private String title;
    @Column(name = "desc")
    private String desc;
    @Column(name = "rltime",nullable = false)
    private Date rltime;
    @Column(name = "delinetime", nullable =false )
    private Date delineTime;

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

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", rltime=" + rltime +
                ", delineTime=" + delineTime +
                '}';
    }
}
