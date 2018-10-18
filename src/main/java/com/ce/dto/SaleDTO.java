package com.ce.dto;

public class SaleDTO {

    private Integer idSaleTable;
    private String salesNumber;
    private Double amount;
    private String nameClient;
    private String currency;
    private String dateCreation;

    public SaleDTO(Integer idSaleTable, String salesNumber, Double amount, String nameClient, String currency, String dateCreation) {
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

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
}
