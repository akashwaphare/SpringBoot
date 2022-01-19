package com.example.virus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.virus.model.informetion;

@Repository
public interface informetionRepository extends JpaRepository<informetion,Long>
{

	
}
