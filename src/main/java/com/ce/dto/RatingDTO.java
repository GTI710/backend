package com.ce.dto;

public class RatingDTO {

    private Integer idRatingTable;
    private Integer idProductTemplate;
    private Double score;
    private String dateCreation;

    public RatingDTO(Integer idRatingTable, Integer idProductTemplate, Double score, String dateCreation) {
        this.idRatingTable = idRatingTable;
        this.idProductTemplate = idProductTemplate;
        this.score = score;
        this.dateCreation = dateCreation;
    }

    public Integer getIdRatingTable() {
        return idRatingTable;
    }

    public void setIdRatingTable(Integer idRatingTable) {
        this.idRatingTable = idRatingTable;
    }

    public Integer getIdProductTemplate() {
        return idProductTemplate;
    }

    public void setIdProductTemplate(Integer idProductTemplate) {
        this.idProductTemplate = idProductTemplate;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
}
