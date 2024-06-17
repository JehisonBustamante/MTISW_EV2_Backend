package com.tutorial.reportesservice.repository;

import com.tutorial.reportesservice.entity.ReportesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportesRepository extends JpaRepository<ReportesEntity, Integer> {
}
