package com.ce.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "commenttable")
public class CommentTable {


    @Id

    @SequenceGenerator(name = "commenttable_idcommenttable_seq", sequenceName = "commenttable_idcommenttable_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commenttable_idcommenttable_seq")
    @Column(name = "idcommenttable")
    private Integer idCommentTable;

    @Column(name = "idproducttemplate")
    private Integer idProductTemplate;

    @Column(name = "body")
    private String body;

    @Column(name = "datecreation")
    private Date dateCreation;

    public CommentTable() {
    }

    public CommentTable(Integer idCommentTable, Integer idProductTemplate, String body, Date dateCreation) {
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

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
