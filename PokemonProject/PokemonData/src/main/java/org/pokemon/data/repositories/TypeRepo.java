package org.pokemon.data.repositories;

import org.pokemon.data.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepo extends JpaRepository<Type, Long> {
    Type findByName(String name);
}
