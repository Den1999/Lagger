package by.vsu.Lagger.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Zver.
 */
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

    public Long getId() {
        return id;
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
}
