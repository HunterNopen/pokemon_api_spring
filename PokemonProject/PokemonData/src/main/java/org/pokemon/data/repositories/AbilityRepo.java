package org.pokemon.data.repositories;

import org.pokemon.data.entity.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityRepo extends JpaRepository<Ability, Long> {
    Ability findByName(String name);
}
