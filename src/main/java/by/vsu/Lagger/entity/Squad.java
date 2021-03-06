package by.vsu.Lagger.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zver.
 */
@Entity
@Table(name = "Squads")
public class Squad implements Serializable {

    private static final long serialVersionUID = -7788619177798333712L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "mainSname")
    private String mainSname;

    @Column(name = "mainFname")
    private String mainFname;

    @Column(name = "mainPatron")
    private String mainPatron;

    @Column(name = "maxChildren")
    private Short maxChildren;

    @Column(name = "number")
    private Short number;

    @OneToMany(mappedBy = "squad", fetch = FetchType.LAZY)
    private Set<Child> children = new HashSet<>();

    public Squad(Long id) {
        this.id = id;
    }

    public Squad(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Squad squad = (Squad) o;

        if (id != null ? !id.equals(squad.id) : squad.id != null) return false;
        if (mainSname != null ? !mainSname.equals(squad.mainSname) : squad.mainSname != null) return false;
        if (mainFname != null ? !mainFname.equals(squad.mainFname) : squad.mainFname != null) return false;
        if (mainPatron != null ? !mainPatron.equals(squad.mainPatron) : squad.mainPatron != null) return false;
        if (maxChildren != null ? !maxChildren.equals(squad.maxChildren) : squad.maxChildren != null) return false;
        if (number != null ? !number.equals(squad.number) : squad.number != null) return false;
        return children != null ? children.equals(squad.children) : squad.children == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (mainSname != null ? mainSname.hashCode() : 0);
        result = 31 * result + (mainFname != null ? mainFname.hashCode() : 0);
        result = 31 * result + (mainPatron != null ? mainPatron.hashCode() : 0);
        result = 31 * result + (maxChildren != null ? maxChildren.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (children != null ? children.hashCode() : 0);
        return result;
    }

    public Long getId() {
        try {
            return id;
        }
        catch (NullPointerException e){
            return null;
        }
    }


    public Short getNumber() {
        return number;
    }

    public void setNumber(Short number) {
        this.number = number;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMainSname() {
        return mainSname;
    }

    public void setMainSname(String mainSname) {
        this.mainSname = mainSname;
    }

    public String getMainFname() {
        return mainFname;
    }

    public void setMainFname(String mainFname) {
        this.mainFname = mainFname;
    }

    public String getMainPatron() {
        return mainPatron;
    }

    public void setMainPatron(String mainPatron) {
        this.mainPatron = mainPatron;
    }

    public Short getMaxChildren() {
        return maxChildren;
    }

    public void setMaxChildren(Short maxChildren) {
        this.maxChildren = maxChildren;
    }

    @Override
    public String toString() {
        return "{" +
                "\n\"id\":" + id +
                ", \n\"number\":\"" + number + '\"' +
                ", \n\"mainSname\":\"" + mainSname + '\"' +
                ", \n\"mainFname\":\"" + mainFname + '\"' +
                ", \n\"mainPatron\":\"" + mainPatron + '\"' +
                ", \n\"maxChildren\":\"" + maxChildren + '\"' +
                "\n}";
    }

}
