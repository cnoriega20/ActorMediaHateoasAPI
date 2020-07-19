package com.springboot.hateoas.springboootHateoas.domain;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(notes = "Album ID",name="id", required=true, value="test id")
    private Long id;

    @ApiModelProperty(notes = "Album title",name="title", required=true, value="test title")
    private String title;

    @ApiModelProperty(notes = "Album description",name="description", required=true, value="test description")
    private String  description;

    @ApiModelProperty(notes = "Album release date",name="releaseDate",required=true, value="test release date")
    private String releaseDate;

    @ApiModelProperty(notes = "Album related list of actors",name="actors", required=true, value="List of actors")
    @ManyToMany(mappedBy = "albums", fetch = FetchType.EAGER)
    private List<ActorEntity> actors;

}
