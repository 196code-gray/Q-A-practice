package com.codestates.QA.repository;

import com.codestates.QA.entity.Bord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Bord, Long> {

}
