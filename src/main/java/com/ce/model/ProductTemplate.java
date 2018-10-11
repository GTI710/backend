package com.ce.model;

import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.util.Date;

@Indexed
@Entity
@Table(name = "product_template")
public class ProductTemplate {


    @Id

    @SequenceGenerator(name = "producttemplate_idproducttemplate_seq", sequenceName = "producttemplate_idproducttemplate_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producttemplate_idproducttemplate_seq")
    @Column(name = "id")
    private Integer idProductTemplate;

    @Column(name = "name")
    private String name;

    @Column(name = "sequence")
    private Integer sequence;

    @Column(name = "description")
    private String description;

    @Column(name = "description_purchase")
    private String descriptionPurchase;

    @Column(name = "description_sale")
    private String descriptionSale;

    @Column(name = "type")
    private String type;

    @Column(name = "rental")
    private String rental;

    @Column(name = "categ_id")
    private Integer idCategory;

    @Column(name = "list_price")
    private Double listPrice;

    @Column(name = "volume")
    private Double volume;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "sale_ok")
    private Boolean saleOk;

    @Column(name = "purchase_ok")
    private Boolean purchaseOk;

    @Column(name = "uom_id")
    private Integer idUOM;

    @Column(name = "uom_po_id")
    private Integer idUOMPO;

    @Column(name = "company_id")
    private Integer idCompany;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "color")
    private Integer color;

    @Column(name = "default_code")
    private String defaultCode;

    @Column(name = "create_uid")
    private Integer createUID;

    @Column(name = "create_date")
    private Date dateCreated;

    @Column(name = "write_uid")
    private Integer writeUID;

    @Column(name = "write_date")
    private Date dateWrite;

    @Column(name = "responsible_id")
    private Integer idResponsible;

    @Column(name = "sale_delay")
    private Double saleDelay;

    @Column(name = "tracking")
    private String tracking;

    @Column(name = "description_picking")
    private String descriptionPicking;

    @Column(name = "description_pickingout")
    private String descriptionPickingOut;

    @Column(name = "description_pickingin")
    private String descriptionPickingIn;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "sale_line_warn")
    private String saleLineWarn;

    @Column(name = "sale_line_warn_msg")
    private String saleLineWarnMsg;

    @Column(name = "expense_policy")
    private String expensePolicy;

    @Column(name = "rating_last_value")
    private Double ratingLastValue;

    @Column(name = "website_meta_title")
    private String websiteMetaTitle;

    @Column(name = "website_meta_description")
    private String websiteMetaDescription;

    @Column(name = "website_meta_keywords")
    private String websiteMetaKeywords;

    @Column(name = "website_meta_og_img")
    private String websiteMetaOgImg;

    @Column(name = "website_id")
    private Integer websiteId;

    @Column(name = "is_published")
    private Boolean isPublished;

    @Column(name = "website_description")
    private String websiteDescription;

    @Column(name = "website_size_x")
    private Integer websiteSizeX;

    @Column(name = "website_size_y")
    private Integer websiteSizeY;

    @Column(name = "website_sequence")
    private Integer websiteSequence;

    @Column(name = "inventory_availability")
    private String inventoryAvailability;

    @Column(name = "available_threshold")
    private Double availableThreshold;

    @Column(name = "custom_message")
    private String customMessage;

    public ProductTemplate() {
    }

    public ProductTemplate(Integer idProductTemplate, String name, Integer sequence, String description, String descriptionPurchase, String descriptionSale, String type, String rental, Integer idCategory, Double listPrice, Double volume, Double weight, Boolean saleOk, Boolean purchaseOk, Integer idUOM, Integer idUOMPO, Integer idCompany, Boolean active, Integer color, String defaultCode, Integer createUID, Date dateCreated, Integer writeUID, Date dateWrite, Integer idResponsible, Double saleDelay, String tracking, String descriptionPicking, String descriptionPickingOut, String descriptionPickingIn, String serviceType, String saleLineWarn, String saleLineWarnMsg, String expensePolicy, Double ratingLastValue, String websiteMetaTitle, String websiteMetaDescription, String websiteMetaKeywords, String websiteMetaOgImg, Integer websiteId, Boolean isPublished, String websiteDescription, Integer websiteSizeX, Integer websiteSizeY, Integer websiteSequence, String inventoryAvailability, Double availableThreshold, String customMessage) {
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
        this.idUOM = idUOM;
        this.idUOMPO = idUOMPO;
        this.idCompany = idCompany;
        this.active = active;
        this.color = color;
        this.defaultCode = defaultCode;
        this.createUID = createUID;
        this.dateCreated = dateCreated;
        this.writeUID = writeUID;
        this.dateWrite = dateWrite;
        this.idResponsible = idResponsible;
        this.saleDelay = saleDelay;
        this.tracking = tracking;
        this.descriptionPicking = descriptionPicking;
        this.descriptionPickingOut = descriptionPickingOut;
        this.descriptionPickingIn = descriptionPickingIn;
        this.serviceType = serviceType;
        this.saleLineWarn = saleLineWarn;
        this.saleLineWarnMsg = saleLineWarnMsg;
        this.expensePolicy = expensePolicy;
        this.ratingLastValue = ratingLastValue;
        this.websiteMetaTitle = websiteMetaTitle;
        this.websiteMetaDescription = websiteMetaDescription;
        this.websiteMetaKeywords = websiteMetaKeywords;
        this.websiteMetaOgImg = websiteMetaOgImg;
        this.websiteId = websiteId;
        this.isPublished = isPublished;
        this.websiteDescription = websiteDescription;
        this.websiteSizeX = websiteSizeX;
        this.websiteSizeY = websiteSizeY;
        this.websiteSequence = websiteSequence;
        this.inventoryAvailability = inventoryAvailability;
        this.availableThreshold = availableThreshold;
        this.customMessage = customMessage;
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

    public Integer getIdUOM() {
        return idUOM;
    }

    public void setIdUOM(Integer idUOM) {
        this.idUOM = idUOM;
    }

    public Integer getIdUOMPO() {
        return idUOMPO;
    }

    public void setIdUOMPO(Integer idUOMPO) {
        this.idUOMPO = idUOMPO;
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public String getDefaultCode() {
        return defaultCode;
    }

    public void setDefaultCode(String defaultCode) {
        this.defaultCode = defaultCode;
    }

    public Integer getCreateUID() {
        return createUID;
    }

    public void setCreateUID(Integer createUID) {
        this.createUID = createUID;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getWriteUID() {
        return writeUID;
    }

    public void setWriteUID(Integer writeUID) {
        this.writeUID = writeUID;
    }

    public Date getDateWrite() {
        return dateWrite;
    }

    public void setDateWrite(Date dateWrite) {
        this.dateWrite = dateWrite;
    }

    public Integer getIdResponsible() {
        return idResponsible;
    }

    public void setIdResponsible(Integer idResponsible) {
        this.idResponsible = idResponsible;
    }

    public Double getSaleDelay() {
        return saleDelay;
    }

    public void setSaleDelay(Double saleDelay) {
        this.saleDelay = saleDelay;
    }

    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public String getDescriptionPicking() {
        return descriptionPicking;
    }

    public void setDescriptionPicking(String descriptionPicking) {
        this.descriptionPicking = descriptionPicking;
    }

    public String getDescriptionPickingOut() {
        return descriptionPickingOut;
    }

    public void setDescriptionPickingOut(String descriptionPickingOut) {
        this.descriptionPickingOut = descriptionPickingOut;
    }

    public String getDescriptionPickingIn() {
        return descriptionPickingIn;
    }

    public void setDescriptionPickingIn(String descriptionPickingIn) {
        this.descriptionPickingIn = descriptionPickingIn;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getSaleLineWarn() {
        return saleLineWarn;
    }

    public void setSaleLineWarn(String saleLineWarn) {
        this.saleLineWarn = saleLineWarn;
    }

    public String getSaleLineWarnMsg() {
        return saleLineWarnMsg;
    }

    public void setSaleLineWarnMsg(String saleLineWarnMsg) {
        this.saleLineWarnMsg = saleLineWarnMsg;
    }

    public String getExpensePolicy() {
        return expensePolicy;
    }

    public void setExpensePolicy(String expensePolicy) {
        this.expensePolicy = expensePolicy;
    }

    public Double getRatingLastValue() {
        return ratingLastValue;
    }

    public void setRatingLastValue(Double ratingLastValue) {
        this.ratingLastValue = ratingLastValue;
    }

    public String getWebsiteMetaTitle() {
        return websiteMetaTitle;
    }

    public void setWebsiteMetaTitle(String websiteMetaTitle) {
        this.websiteMetaTitle = websiteMetaTitle;
    }

    public String getWebsiteMetaDescription() {
        return websiteMetaDescription;
    }

    public void setWebsiteMetaDescription(String websiteMetaDescription) {
        this.websiteMetaDescription = websiteMetaDescription;
    }

    public String getWebsiteMetaKeywords() {
        return websiteMetaKeywords;
    }

    public void setWebsiteMetaKeywords(String websiteMetaKeywords) {
        this.websiteMetaKeywords = websiteMetaKeywords;
    }

    public String getWebsiteMetaOgImg() {
        return websiteMetaOgImg;
    }

    public void setWebsiteMetaOgImg(String websiteMetaOgImg) {
        this.websiteMetaOgImg = websiteMetaOgImg;
    }

    public Integer getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Integer websiteId) {
        this.websiteId = websiteId;
    }

    public Boolean getPublished() {
        return isPublished;
    }

    public void setPublished(Boolean published) {
        isPublished = published;
    }

    public String getWebsiteDescription() {
        return websiteDescription;
    }

    public void setWebsiteDescription(String websiteDescription) {
        this.websiteDescription = websiteDescription;
    }

    public Integer getWebsiteSizeX() {
        return websiteSizeX;
    }

    public void setWebsiteSizeX(Integer websiteSizeX) {
        this.websiteSizeX = websiteSizeX;
    }

    public Integer getWebsiteSizeY() {
        return websiteSizeY;
    }

    public void setWebsiteSizeY(Integer websiteSizeY) {
        this.websiteSizeY = websiteSizeY;
    }

    public Integer getWebsiteSequence() {
        return websiteSequence;
    }

    public void setWebsiteSequence(Integer websiteSequence) {
        this.websiteSequence = websiteSequence;
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

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }
}
