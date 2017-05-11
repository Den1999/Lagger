package by.vsu.Lagger.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zver.
 */
@Entity
@Table(name = "Addresses")
public class Address implements Serializable {

    private static final long serialVersionUID = -7788619177798333712L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private Short house;

    @Column(name = "pavilion")
    private Short pavilion;

    @Column(name = "flat")
    private Short flat;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private Set<Parent> parents = new HashSet<>();

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private Set<Child> children = new HashSet<>();

    public Address(Long id) {
        this.id = id;
    }

    public Address() {
    }

    public Long getId() {
        try {
            return id;
        }
        catch (NullPointerException e){
            return null;
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Short getHouse() {
        return house;
    }

    public void setHouse(Short house) {
        this.house = house;
    }

    public Short getPavilion() {
        return pavilion;
    }

    public void setPavilion(Short pavilion) {
        this.pavilion = pavilion;
    }

    public Short getFlat() {
        return flat;
    }

    public void setFlat(Short flat) {
        this.flat = flat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (id != null ? !id.equals(address.id) : address.id != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (house != null ? !house.equals(address.house) : address.house != null) return false;
        if (pavilion != null ? !pavilion.equals(address.pavilion) : address.pavilion != null) return false;
        if (flat != null ? !flat.equals(address.flat) : address.flat != null) return false;
        if (phone != null ? !phone.equals(address.phone) : address.phone != null) return false;
        if (parents != null ? !parents.equals(address.parents) : address.parents != null) return false;
        return children != null ? children.equals(address.children) : address.children == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (house != null ? house.hashCode() : 0);
        result = 31 * result + (pavilion != null ? pavilion.hashCode() : 0);
        result = 31 * result + (flat != null ? flat.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (parents != null ? parents.hashCode() : 0);
        result = 31 * result + (children != null ? children.hashCode() : 0);
        return result;
    }
}
