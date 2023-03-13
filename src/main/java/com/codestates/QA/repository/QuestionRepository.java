package com.codestates.QA.repository;

import com.codestates.QA.entity.Bord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Bord, Long> {
    Optional<Bord> findByEmail(String Email);
}
