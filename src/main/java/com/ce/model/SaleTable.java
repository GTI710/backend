package com.ce.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "saletable")
public class SaleTable {


    @Id

    @SequenceGenerator(name = "saletable_idsaletable_seq", sequenceName = "saletable_idsaletable_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "saletable_idsaletable_seq")
    @Column(name = "idsaletable")
    private Integer idSaleTable;

    @Column(name = "salesnumber")
    private String salesNumber;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "nameclient")
    private String nameClient;

    @Column(name = "currency")
    private String currency;

    @Column(name = "datecreation")
    private Date dateCreation;

    public SaleTable() {
    }

    public SaleTable(Integer idSaleTable, String salesNumber, Double amount, String nameClient, String currency, Date dateCreation) {
        this.idSaleTable = idSaleTable;
        this.salesNumber = salesNumber;
        this.amount = amount;
        this.nameClient = nameClient;
        this.currency = currency;
        this.dateCreation = dateCreation;
    }

    public Integer getIdSaleTable() {
        return idSaleTable;
    }

    public void setIdSaleTable(Integer idSaleTable) {
        this.idSaleTable = idSaleTable;
    }

    public String getSalesNumber() {
        return salesNumber;
    }

    public void setSalesNumber(String salesNumber) {
        this.salesNumber = salesNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
