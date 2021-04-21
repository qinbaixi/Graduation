package cn.qut.graduation.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class Student implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "sid")
    private Integer sid;
    @Column(name = "name")
    private String name;
    @Column(name = "cid")
    private Integer cid;

    @Transient
    private String pwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sid=" + sid +
                ", name='" + name + '\'' +
                ", cid=" + cid +
                '}';
    }
}
