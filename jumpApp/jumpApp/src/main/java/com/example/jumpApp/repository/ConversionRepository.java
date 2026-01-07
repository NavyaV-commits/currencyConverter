package com.example.jumpApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jumpApp.model.Conversion;

@Repository
public interface ConversionRepository extends JpaRepository<Conversion, Long>{

}
