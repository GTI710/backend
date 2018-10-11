package com.ce.service;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.FuzzyContext;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.search.query.dsl.TermMatchingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Service
public class HibernateSearchService {


    @Autowired
    private final EntityManager centityManager;


    @Autowired
    public HibernateSearchService(EntityManager entityManager) {
        super();
        this.centityManager = entityManager;
    }

    public void initializeHibernateSearch() {

        try {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(centityManager);
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public List<?> fuzzySearch(String searchTerm, List<String> fields, Object object, PageRequest pageRequest) {

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(centityManager);
        QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(object.getClass()).get();

        Query luceneQuery = null;

        FuzzyContext fuzzyContext = qb.keyword().fuzzy().withEditDistanceUpTo(1).withPrefixLength(1);
        TermMatchingContext termMatchingContext = null;
        for (String field : fields) {
            termMatchingContext = fuzzyContext.onFields(field);
        }

        luceneQuery = termMatchingContext.matching(searchTerm).createQuery();



        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, object.getClass()).setFirstResult(pageRequest.getPageNumber()*pageRequest.getPageSize()).setMaxResults(pageRequest.getPageSize());

        // execute search
        List<?> list = null;
        try {
            list = jpaQuery.getResultList();
        } catch (NoResultException nre) {

        }

        return list;
    }


}