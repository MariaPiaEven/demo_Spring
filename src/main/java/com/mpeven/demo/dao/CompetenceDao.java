package com.mpeven.demo.dao;

import com.mpeven.demo.model.Competence;
import com.mpeven.demo.model.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceDao extends JpaRepository<Competence, Integer> {



}
