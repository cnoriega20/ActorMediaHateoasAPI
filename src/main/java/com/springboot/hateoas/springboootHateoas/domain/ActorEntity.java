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
@ToString(exclude="Albums")
@Entity
@Table(name = "actor")
public class ActorEntity implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Actor ID",name="id",required=true,value="test id")
    private Long id;

    @ApiModelProperty(notes = "Actor first name",name="firstName",required=true,value="test name")
    private String firstName;

    @ApiModelProperty(notes = "Actor last name",name="lastName",required=true,value="test last name")
    private String lastName;

    @ApiModelProperty(notes = "Actor birth date",name="birthDate",required=true,value="test birthday")
    private String birthDate;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "actor_album",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name="album_id"))
    private List<AlbumEntity> albums;

   /* public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }*/
}
