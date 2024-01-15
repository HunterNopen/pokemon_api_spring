package org.pokemon.data.repositories;

import org.pokemon.data.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Long> {
    Item findByName(String name);
}
