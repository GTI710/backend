package com.ce.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "deliverytable")
public class DeliveryTable {


    @Id

    @SequenceGenerator(name = "deliverytable_iddeliverytable_seq", sequenceName = "deliverytable_iddeliverytable_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deliverytable_iddeliverytable_seq")
    @Column(name = "iddeliverytable")
    private Integer idDeliveryTable;

    @Column(name = "idsaletable")
    private Integer idSaleTable;

    @Column(name = "street")
    private String street;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "datecreation")
    private Date dateCreation;

    public DeliveryTable() {
    }

    public DeliveryTable(Integer idDeliveryTable, Integer idSaleTable, String street, String zipcode, String city, String country, Date dateCreation) {
        this.idDeliveryTable = idDeliveryTable;
        this.idSaleTable = idSaleTable;
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.dateCreation = dateCreation;
    }

    public Integer getIdDeliveryTable() {
        return idDeliveryTable;
    }

    public void setIdDeliveryTable(Integer idDeliveryTable) {
        this.idDeliveryTable = idDeliveryTable;
    }

    public Integer getIdSaleTable() {
        return idSaleTable;
    }

    public void setIdSaleTable(Integer idSaleTable) {
        this.idSaleTable = idSaleTable;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
