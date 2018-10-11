package com.ce.dto;

public class ProductCategoryDTO {

    private Integer idProductCategory;
    private String parentPath;
    private String name;
    private String completeName;
    private String idParent;
    private Integer createUID;
    private String dateCreated;
    private Integer writeUID;
    private String dateWrite;
    private Integer idRemovalStrategy;

    public ProductCategoryDTO() {
    }

    public ProductCategoryDTO(Integer idProductCategory, String parentPath, String name, String completeName, String idParent, Integer createUID, String dateCreated, Integer writeUID, String dateWrite, Integer idRemovalStrategy) {
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

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getWriteUID() {
        return writeUID;
    }

    public void setWriteUID(Integer writeUID) {
        this.writeUID = writeUID;
    }

    public String getDateWrite() {
        return dateWrite;
    }

    public void setDateWrite(String dateWrite) {
        this.dateWrite = dateWrite;
    }

    public Integer getIdRemovalStrategy() {
        return idRemovalStrategy;
    }

    public void setIdRemovalStrategy(Integer idRemovalStrategy) {
        this.idRemovalStrategy = idRemovalStrategy;
    }
}
