package cn.qut.graduation.pojo;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hcommit")
public class HCommit implements Serializable {
    @EmbeddedId
    private IdExtension id;

    @Column(name = "title")
    private String title;
    @Column(name = "score")
    private Integer score;
    @Column(name = "branch")
    private String branch;
    @Column(name = "radress")
    private String radress;

    public String getRadress() {
        return radress;
    }

    public void setRadress(String radress) {
        this.radress = radress;
    }

    public IdExtension getId() {
        return id;
    }

    public void setId(IdExtension id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "HCommit{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", score=" + score +
                ", branch='" + branch + '\'' +
                ", radress='" + radress + '\'' +
                '}';
    }
}
