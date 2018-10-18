package com.ce.repository;

import com.ce.model.CommentTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<CommentTable, Integer> {

    List<CommentTable> findAllByIdProductTemplate(Integer idProductTemplate);
}
