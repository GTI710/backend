package com.ce.dto;

public class ProductTemplateDTO {

    private Integer idProductTemplate;
    private String name;
    private Integer sequence;
    private String description;
    private String descriptionPurchase;
    private String descriptionSale;
    private String type;
    private String rental;
    private Integer idCategory;
    private Double listPrice;
    private Double volume;
    private Double weight;
    private Boolean saleOk;
    private Boolean purchaseOk;
    private Boolean active;
    private String dateCreated;
    private String dateWrite;
    private Double ratingLastValue;
    private String websiteMetaOgImg;
    private Boolean isPublished;
    private String inventoryAvailability;
    private Double availableThreshold;

    public ProductTemplateDTO() {
    }

    public ProductTemplateDTO(Integer idProductTemplate, String name, Integer sequence, String description, String descriptionPurchase, String descriptionSale, String type, String rental, Integer idCategory, Double listPrice, Double volume, Double weight, Boolean saleOk, Boolean purchaseOk, Boolean active, String dateCreated, String dateWrite, Double ratingLastValue, String websiteMetaOgImg, Boolean isPublished, String inventoryAvailability, Double availableThreshold) {
        this.idProductTemplate = idProductTemplate;
        this.name = name;
        this.sequence = sequence;
        this.description = description;
        this.descriptionPurchase = descriptionPurchase;
        this.descriptionSale = descriptionSale;
        this.type = type;
        this.rental = rental;
        this.idCategory = idCategory;
        this.listPrice = listPrice;
        this.volume = volume;
        this.weight = weight;
        this.saleOk = saleOk;
        this.purchaseOk = purchaseOk;
        this.active = active;
        this.dateCreated = dateCreated;
        this.dateWrite = dateWrite;
        this.ratingLastValue = ratingLastValue;
        this.websiteMetaOgImg = websiteMetaOgImg;
        this.isPublished = isPublished;
        this.inventoryAvailability = inventoryAvailability;
        this.availableThreshold = availableThreshold;
    }

    public Integer getIdProductTemplate() {
        return idProductTemplate;
    }

    public void setIdProductTemplate(Integer idProductTemplate) {
        this.idProductTemplate = idProductTemplate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionPurchase() {
        return descriptionPurchase;
    }

    public void setDescriptionPurchase(String descriptionPurchase) {
        this.descriptionPurchase = descriptionPurchase;
    }

    public String getDescriptionSale() {
        return descriptionSale;
    }

    public void setDescriptionSale(String descriptionSale) {
        this.descriptionSale = descriptionSale;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRental() {
        return rental;
    }

    public void setRental(String rental) {
        this.rental = rental;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Boolean getSaleOk() {
        return saleOk;
    }

    public void setSaleOk(Boolean saleOk) {
        this.saleOk = saleOk;
    }

    public Boolean getPurchaseOk() {
        return purchaseOk;
    }

    public void setPurchaseOk(Boolean purchaseOk) {
        this.purchaseOk = purchaseOk;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateWrite() {
        return dateWrite;
    }

    public void setDateWrite(String dateWrite) {
        this.dateWrite = dateWrite;
    }

    public Double getRatingLastValue() {
        return ratingLastValue;
    }

    public void setRatingLastValue(Double ratingLastValue) {
        this.ratingLastValue = ratingLastValue;
    }

    public String getWebsiteMetaOgImg() {
        return websiteMetaOgImg;
    }

    public void setWebsiteMetaOgImg(String websiteMetaOgImg) {
        this.websiteMetaOgImg = websiteMetaOgImg;
    }

    public Boolean getPublished() {
        return isPublished;
    }

    public void setPublished(Boolean published) {
        isPublished = published;
    }

    public String getInventoryAvailability() {
        return inventoryAvailability;
    }

    public void setInventoryAvailability(String inventoryAvailability) {
        this.inventoryAvailability = inventoryAvailability;
    }

    public Double getAvailableThreshold() {
        return availableThreshold;
    }

    public void setAvailableThreshold(Double availableThreshold) {
        this.availableThreshold = availableThreshold;
    }
}
