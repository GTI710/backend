package com.ce.model;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.util.Date;

@Indexed
@Entity
@Table(name = "product_category")
public class ProductCategory {


    @Id

    @SequenceGenerator(name = "productcategory_idproductcategory_seq", sequenceName = "productcategory_idproductcategory_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productcategory_idproductcategory_seq")
    @Column(name = "id")
    private Integer idProductCategory;

    @Column(name = "parent_path")
    private String parentPath;

    @Column(name = "name")
    private String name;

    @Column(name = "complete_name")
    private String completeName;

    @Column(name = "parent_id")
    private String idParent;

    @Column(name = "create_uid")
    private Integer createUID;

    @Column(name = "create_date")
    private Date dateCreated;

    @Column(name = "write_uid")
    private Integer writeUID;

    @Column(name = "write_date")
    private Date dateWrite;

    @Column(name = "removal_strategy_id")
    private Integer idRemovalStrategy;

    public ProductCategory() {
    }

    public ProductCategory(Integer idProductCategory, String parentPath, String name,
                           String completeName, String idParent, Integer createUID,
                           Date dateCreated, Integer writeUID, Date dateWrite, Integer idRemovalStrategy) {
        this.idProductCategory = idProductCategory;
        this.parentPath = parentPath;
        this.name = name;
        this.completeName = completeName;
        this.idParent = idParent;
        this.createUID = createUID;
        this.dateCreated = dateCreated;
        this.writeUID = writeUID;
        this.dateWrite = dateWrite;
        this.idRemovalStrategy = idRemovalStrategy;
    }

    public Integer getIdProductCategory() {
        return idProductCategory;
    }

    public void setIdProductCategory(Integer idProductCategory) {
        this.idProductCategory = idProductCategory;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public String getIdParent() {
        return idParent;
    }

    public void setIdParent(String idParent) {
        this.idParent = idParent;
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

    public Integer getIdRemovalStrategy() {
        return idRemovalStrategy;
    }

    public void setIdRemovalStrategy(Integer idRemovalStrategy) {
        this.idRemovalStrategy = idRemovalStrategy;
    }
}
