package org.pokemon.data.repositories;

import org.pokemon.data.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatRepo extends JpaRepository<Stat, Long> {
    Stat findByName(String name);
}
