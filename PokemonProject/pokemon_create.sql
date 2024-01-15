DROP DATABASE pokemondb;
Create DATABASE pokemondb;
USE pokemondb;
CREATE TABLE ability (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255),
                         url VARCHAR(255)
);
CREATE TABLE pokemon_abilities (
                                   id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                   is_hidden BOOLEAN,
                                   slot INTEGER
);
CREATE TABLE item (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      name VARCHAR(255),
                      url VARCHAR(255)
);
CREATE TABLE pokemon_held_items (
                                    id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                    item_id BIGINT,
                                    FOREIGN KEY (item_id) REFERENCES item (id)
);
CREATE TABLE pokemon_sprites (
                                 id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                 front_default VARCHAR(255),
                                 front_shiny VARCHAR(255),
                                 front_female VARCHAR(255),
                                 front_shiny_female VARCHAR(255),
                                 back_default VARCHAR(255),
                                 back_shiny VARCHAR(255),
                                 back_female VARCHAR(255),
                                 back_shiny_female VARCHAR(255)
);
CREATE TABLE stat (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      name VARCHAR(255),
                      url VARCHAR(255)
);
CREATE TABLE pokemon_stats (
                               id BIGINT PRIMARY KEY AUTO_INCREMENT,
                               stat_id BIGINT,
                               effort INTEGER,
                               base_stat INTEGER,
                               FOREIGN KEY (stat_id) REFERENCES stat (id)
);
CREATE TABLE type (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      name VARCHAR(255),
                      url VARCHAR(255)
);
CREATE TABLE pokemon_types (
                               id BIGINT PRIMARY KEY AUTO_INCREMENT,
                               slot INTEGER,
                               type_id BIGINT,
                               FOREIGN KEY (type_id) REFERENCES type (id)
);
CREATE TABLE pokemon (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255),
                         base_experience INTEGER,
                         height INTEGER,
                         is_default BOOLEAN,
                         order_number INTEGER,
                         weight INTEGER,
                         location_area_encounters VARCHAR(255),
                         sprites_id BIGINT,
                         pokemon_abilities_id BIGINT,
                         pokemon_held_items_id BIGINT,
                         pokemon_stats_id BIGINT,
                         pokemon_types_id BIGINT,
                         FOREIGN KEY (sprites_id) REFERENCES pokemon_sprites (id),
                         FOREIGN KEY (pokemon_abilities_id) REFERENCES pokemon_abilities (id),
                         FOREIGN KEY (pokemon_held_items_id) REFERENCES pokemon_held_items (id),
                         FOREIGN KEY (pokemon_stats_id) REFERENCES pokemon_stats (id),
                         FOREIGN KEY (pokemon_types_id) REFERENCES pokemon_types (id)
);
ALTER TABLE pokemon_sprites
    ADD COLUMN pokemon_id BIGINT,
    ADD FOREIGN KEY (pokemon_id) REFERENCES Pokemon(id);

ALTER TABLE pokemon_abilities
    ADD COLUMN ability_id BIGINT,
    ADD FOREIGN KEY (ability_id) REFERENCES ability (id),
    ADD COLUMN pokemon_id BIGINT,
    ADD FOREIGN KEY (pokemon_id) REFERENCES Pokemon(id);

ALTER TABLE pokemon_held_items
    ADD COLUMN pokemon_id BIGINT,
    ADD FOREIGN KEY (pokemon_id) REFERENCES Pokemon(id);

ALTER TABLE pokemon_stats
    ADD COLUMN pokemon_id BIGINT,
    ADD FOREIGN KEY (pokemon_id) REFERENCES Pokemon(id);

ALTER TABLE pokemon_types
    ADD COLUMN pokemon_id BIGINT,
    ADD FOREIGN KEY (pokemon_id) REFERENCES Pokemon(id);