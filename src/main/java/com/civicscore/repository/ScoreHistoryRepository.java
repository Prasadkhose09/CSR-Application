package com.civicscore.repository;


import com.civicscore.entity.ScoreHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreHistoryRepository extends JpaRepository<ScoreHistory, Long> {
}
