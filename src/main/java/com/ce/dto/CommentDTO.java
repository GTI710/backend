package com.ce.dto;

public class CommentDTO {

    private Integer idCommentTable;
    private Integer idProductTemplate;
    private String body;
    private String dateCreation;

    public CommentDTO(Integer idCommentTable, Integer idProductTemplate, String body, String dateCreation) {
        this.idCommentTable = idCommentTable;
        this.idProductTemplate = idProductTemplate;
        this.body = body;
        this.dateCreation = dateCreation;
    }

    public Integer getIdCommentTable() {
        return idCommentTable;
    }

    public void setIdCommentTable(Integer idCommentTable) {
        this.idCommentTable = idCommentTable;
    }

    public Integer getIdProductTemplate() {
        return idProductTemplate;
    }

    public void setIdProductTemplate(Integer idProductTemplate) {
        this.idProductTemplate = idProductTemplate;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
}
