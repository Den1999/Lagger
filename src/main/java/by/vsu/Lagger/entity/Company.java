package by.vsu.Lagger.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zver on 30.03.2017.
 */
@Entity
@Table(name = "Companies")
public class Company implements Serializable {

    private static final long serialVersionUID = -7788619177798333712L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "permits")
    private Integer permits;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Parent> parents = new HashSet<>();

    public Company(Long id) {
        this.id = id;
    }

    public Company() {
    }

    public Long getId() {
        try {
            return id;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPermits() {
        return permits;
    }

    public void setPermits(Integer permits) {
        this.permits = permits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return (id != null ? id.equals(company.id) : company.id == null)
                && (title != null ? title.equals(company.title) : company.title == null)
                && (permits != null ? permits.equals(company.permits) : company.permits == null);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (permits != null ? permits.hashCode() : 0);
        return result;
    }
}
