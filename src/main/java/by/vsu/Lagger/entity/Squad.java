package by.vsu.Lagger.entity;

import javax.persistence.*;
import java.io.Serializable;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Squad squad = (Squad) o;

        if (id != null ? !id.equals(squad.id) : squad.id != null) return false;
        if (mainSname != null ? !mainSname.equals(squad.mainSname) : squad.mainSname != null) return false;
        if (mainFname != null ? !mainFname.equals(squad.mainFname) : squad.mainFname != null) return false;
        if (mainPatron != null ? !mainPatron.equals(squad.mainPatron) : squad.mainPatron != null) return false;
        return maxChildren != null ? maxChildren.equals(squad.maxChildren) : squad.maxChildren == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (mainSname != null ? mainSname.hashCode() : 0);
        result = 31 * result + (mainFname != null ? mainFname.hashCode() : 0);
        result = 31 * result + (mainPatron != null ? mainPatron.hashCode() : 0);
        result = 31 * result + (maxChildren != null ? maxChildren.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
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
}
