package com.bartender.bartender.repositories;

import com.bartender.bartender.models.GlassArray;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GlassArrayRepository extends JpaRepository<GlassArray, Long> {

    Optional<GlassArray> findById(Long id);

}
