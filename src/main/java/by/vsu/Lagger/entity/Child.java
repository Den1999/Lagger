package by.vsu.Lagger.entity;


import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zver.
 */
@Entity
@Table(name = "Children")
public class Child implements Serializable {

    private static final long serialVersionUID = -7788619177798333712L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "sname")
    private String sname;

    @Column(name = "fname")
    private String fname;

    @Column(name = "patron")
    private String patron;

    @Column(name = "dob")
    private String dob;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "mphone")
    private String mphone;

    @ManyToOne
    private Squad squad;

    @ManyToOne
    private Address address;

    @ManyToOne
    private Parent parent;

    public Child(Long id) {
        this.id = id;
    }

    public Child(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Child child = (Child) o;

        if (gender != child.gender) return false;
        if (id != null ? !id.equals(child.id) : child.id != null) return false;
        if (sname != null ? !sname.equals(child.sname) : child.sname != null) return false;
        if (fname != null ? !fname.equals(child.fname) : child.fname != null) return false;
        if (patron != null ? !patron.equals(child.patron) : child.patron != null) return false;
        if (dob != null ? !dob.equals(child.dob) : child.dob != null) return false;
        return mphone != null ? mphone.equals(child.mphone) : child.mphone == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (sname != null ? sname.hashCode() : 0);
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (patron != null ? patron.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + (gender ? 1 : 0);
        result = 31 * result + (mphone != null ? mphone.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPatron() {
        return patron;
    }

    public void setPatron(String patron) {
        this.patron = patron;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    public Squad getSquad() {
        try {
            return squad;
        }
        catch (NullPointerException e){
            return null;
        }
    }

    public void setSquad(Squad squad) {
        this.squad = squad;
    }

    public Address getAddress() {
        try {
            return address;
        }
        catch (NullPointerException e){
            return null;
        }
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        Long addressId, squadId;
        if(!StringUtils.isEmpty(address)){
            addressId = address.getId();
        }
        else{
            addressId = null;
        }
        if(!StringUtils.isEmpty(squad)){
            squadId = squad.getId();
        }
        else{
            squadId = null;
        }
            return "{" +
                    "\n\"id\":" + id +
                    ", \n\"sname\":\"" + sname + '\"' +
                    ", \n\"fname\":\"" + fname + '\"' +
                    ", \n\"patron\":\"" + patron + '\"' +
                    ", \n\"dob\":\"" + dob + '\"' +
                    ", \n\"gender\":" + gender +
                    ", \n\"mphone\":\"" + mphone + '\"' +
                        ", \n\"address\":" + addressId +
                    ", \n\"squad\":" + squadId +
                    ", \n\"parent\":" + parent +
                    "\n}";
        }

    public Parent getParent() {
        try {
            return parent;
        }
        catch (NullPointerException e){
            return null;
        }
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
