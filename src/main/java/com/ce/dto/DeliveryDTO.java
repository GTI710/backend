package com.ce.dto;

public class DeliveryDTO {

    private Integer idDeliveryTable;
    private Integer idSaleTable;
    private String street;
    private String zipcode;
    private String city;
    private String country;
    private String dateCreation;

    public DeliveryDTO(Integer idDeliveryTable, Integer idSaleTable, String street, String zipcode, String city, String country, String dateCreation) {
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

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
}
