package com.civicscore.repository;
import com.civicscore.entity.Violation;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ViolationRepository extends JpaRepository<Violation, Long> {

}
