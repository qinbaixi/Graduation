package cn.qut.graduation.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class IdExtension implements Serializable {
    @Column(name = "sid")
    private Integer sid;
    @Column(name = "hid")
    private Integer hid;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj ==null ||getClass() !=obj.getClass()) return false;
        IdExtension that = (IdExtension) obj;

        if (!sid.equals(that.sid)) return false;
        return hid.equals(that.hid);
    }

    @Override
    public int hashCode() {
        int result = sid.hashCode();
        result = 31 * result + hid.hashCode();
        return result;
    }
}
