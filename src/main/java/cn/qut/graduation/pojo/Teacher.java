package cn.qut.graduation.pojo;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "tid")
    private Integer tid;
    @Column(name = "name")
    private String name;

    @Transient
    private Integer pwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
