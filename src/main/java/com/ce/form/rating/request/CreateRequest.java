package com.ce.form.rating.request;

public class CreateRequest {

    private Double score;
    private Integer idProductTemplate;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getIdProductTemplate() {
        return idProductTemplate;
    }

    public void setIdProductTemplate(Integer idProductTemplate) {
        this.idProductTemplate = idProductTemplate;
    }
}
