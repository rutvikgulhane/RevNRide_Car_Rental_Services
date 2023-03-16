package com.revnride.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revnride.app.entity.Localization;

// Interface repository localization to available connect on table database.

@Repository
public interface LocalizationRepository extends JpaRepository<Localization, Long> {
 
    Optional<Localization> findById(Long id);

 
    Optional<Localization> findByCity(String city);

  
    boolean existsByCity(String city);

   
    boolean existsById(Long id);

   
    void deleteByCity(String city);
}
