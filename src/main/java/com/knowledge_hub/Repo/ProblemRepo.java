package com.knowledge_hub.Repo;

import com.knowledge_hub.entity.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProblemRepo extends JpaRepository<Problem, Integer> {
    //List<Problem> findByKeywordsIn(List<String> keywords);

    //List<Problem> findByNameContaining(@Param("name") String name, Pageable Pageable);
    Problem findProblemById(Integer id);

}