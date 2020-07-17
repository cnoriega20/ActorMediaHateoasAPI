package com.springboot.hateoas.springboootHateoas.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "actors")
@Entity
@Table(name="album")
public class AlbumEntity implements Serializable {
    private static final Long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String  description;
    private String releaseDate;

    @ManyToMany(mappedBy = "albums", fetch = FetchType.EAGER)
    private List<ActorEntity> actors;

}
