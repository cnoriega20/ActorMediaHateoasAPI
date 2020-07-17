package com.springboot.hateoas.springboootHateoas.repositories;

import com.springboot.hateoas.springboootHateoas.domain.AlbumEntity;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<AlbumEntity, Long> {
}
