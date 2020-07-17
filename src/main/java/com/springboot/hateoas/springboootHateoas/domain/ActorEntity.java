package com.springboot.hateoas.springboootHateoas.domain;

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
    private Long id;
    private String firstName;
    private String lastName;
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
