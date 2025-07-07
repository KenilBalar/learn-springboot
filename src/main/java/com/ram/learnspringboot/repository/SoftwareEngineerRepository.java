package com.ram.learnspringboot.repository;

import com.ram.learnspringboot.model.SoftwareEngineer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareEngineerRepository extends JpaRepository<SoftwareEngineer,Integer> {
}
