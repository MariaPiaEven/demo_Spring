package com.mpeven.demo.dao;

import com.mpeven.demo.model.Pays;
import com.mpeven.demo.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaysDao extends JpaRepository<Pays, Integer> {



}
