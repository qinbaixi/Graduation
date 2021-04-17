package cn.qut.graduation.pojo;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.util.Date;

@Entity
@Table(name = "homework")
public class Homework {

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
}
