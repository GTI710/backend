package com.ce.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ratingtable")
public class RatingTable {


    @Id

    @SequenceGenerator(name = "ratingtable_idratingtable_seq", sequenceName = "ratingtable_idratingtable_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ratingtable_idratingtable_seq")
    @Column(name = "idratingtable")
    private Integer idRatingTable;

    @Column(name = "idproducttemplate")
    private Integer idProductTemplate;

    @Column(name = "score")
    private Double score;

    @Column(name = "datecreation")
    private Date dateCreation;

    public RatingTable() {
    }

    public RatingTable(Integer idRatingTable, Integer idProductTemplate, Double score, Date dateCreation) {
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

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
