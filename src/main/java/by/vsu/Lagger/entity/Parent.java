package by.vsu.Lagger.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zver.
 */
@Entity
@Table(name = "Parents")
public class Parent implements Serializable {

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

    @Column(name = "relations")
    private String relations;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Address address;

    @ManyToMany
    @JoinTable(name = "chpa",
            joinColumns = @JoinColumn(name = "par_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ch_id", referencedColumnName = "id")
    )
    private Set<Child> children = new HashSet<>();

    public Parent(Long id) {
        this.id = id;
    }

    public Parent() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parent parent = (Parent) o;

        if (gender != parent.gender) return false;
        if (id != null ? !id.equals(parent.id) : parent.id != null) return false;
        if (sname != null ? !sname.equals(parent.sname) : parent.sname != null) return false;
        if (fname != null ? !fname.equals(parent.fname) : parent.fname != null) return false;
        if (patron != null ? !patron.equals(parent.patron) : parent.patron != null) return false;
        if (dob != null ? !dob.equals(parent.dob) : parent.dob != null) return false;
        if (mphone != null ? !mphone.equals(parent.mphone) : parent.mphone != null) return false;
        if (relations != null ? !relations.equals(parent.relations) : parent.relations != null) return false;
        return company != null ? company.equals(parent.company) : parent.company == null;
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
        result = 31 * result + (relations != null ? relations.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
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

    public String getRelations() {
        return relations;
    }

    public void setRelations(String relations) {
        this.relations = relations;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Child> getChildren() {
        return children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "{" +
                "\n\"id\":" + id +
                ", \n\"sname:\"" + sname + '\"' +
                ", \n\"fname:\"" + fname + '\"' +
                ", \n\"patron:\"" + patron + '\"' +
                ", \n\"dob=\"" + dob + '\"' +
                ", \n\"gender:" + gender +
                ", \n\"mphone:\"" + mphone + '\"' +
                ", \n\"relations:\"" + relations + '\"' +
                "\n}";
    }
}
