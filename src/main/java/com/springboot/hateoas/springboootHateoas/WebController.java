package com.springboot.hateoas.springboootHateoas;

import com.springboot.hateoas.springboootHateoas.assemblers.ActorModelAssembler;
import com.springboot.hateoas.springboootHateoas.assemblers.AlbumModelAssembler;
import com.springboot.hateoas.springboootHateoas.domain.ActorEntity;
import com.springboot.hateoas.springboootHateoas.domain.AlbumEntity;
import com.springboot.hateoas.springboootHateoas.model.ActorModel;
import com.springboot.hateoas.springboootHateoas.model.AlbumModel;
import com.springboot.hateoas.springboootHateoas.repositories.ActorRepository;
import com.springboot.hateoas.springboootHateoas.repositories.AlbumRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "WebController", description = "REST Apis to show albums and actor information ")
@RestController
public class WebController {
    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private ActorModelAssembler actorModelAssembler;

    @Autowired
    private AlbumModelAssembler albumModelAssembler;

    @ApiOperation(value = "Get list of Actors in the System ", response = ResponseEntity.class, tags = "getAllActors")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("api/actors")
    public ResponseEntity<CollectionModel<ActorModel>> getAllActors(){
        List<ActorEntity> actorEntities = (List<ActorEntity>) actorRepository.findAll();
        return new ResponseEntity<>(
                actorModelAssembler.toCollectionModel(actorEntities),
                HttpStatus.OK);
    }

    @ApiOperation(value = "Get specific Actor in the System ", response = ResponseEntity.class, tags = "getActorId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/api/actors/{id}")
    public ResponseEntity<ActorModel> getActorId(@PathVariable("id") Long id){
        return actorRepository.findById(id)
                .map(actorModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Get list of Albums in the System ", response = ResponseEntity.class, tags = "getAllAlbums")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/api/albums")
    public ResponseEntity<CollectionModel<AlbumModel>> getAllAlbums(){
        List<AlbumEntity> albumEntities = (List<AlbumEntity>) albumRepository.findAll();
        return new ResponseEntity<>(
                albumModelAssembler.toCollectionModel(albumEntities),
                HttpStatus.OK);
    }
    @ApiOperation(value = "Get specific Album in the System ", response = ResponseEntity.class, tags = "getAlbumId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/api/albums/{id}")
    public ResponseEntity<AlbumModel> getAlbumId(@PathVariable("id") Long id){
        return albumRepository.findById(id)
                .map(albumModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
