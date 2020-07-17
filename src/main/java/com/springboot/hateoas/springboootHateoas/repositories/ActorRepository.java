package com.springboot.hateoas.springboootHateoas.repositories;

import com.springboot.hateoas.springboootHateoas.domain.ActorEntity;
import com.springboot.hateoas.springboootHateoas.domain.AlbumEntity;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<ActorEntity, Long> {
}
