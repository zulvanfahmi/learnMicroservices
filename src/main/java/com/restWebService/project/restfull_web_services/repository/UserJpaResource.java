package com.restWebService.project.restfull_web_services.repository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restWebService.project.restfull_web_services.posts.Post;
import com.restWebService.project.restfull_web_services.posts.PostRepository;
import com.restWebService.project.restfull_web_services.user.User;
import com.restWebService.project.restfull_web_services.user.UserNotFoundException;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserJpaResource {

    private UserRepository UserRepository;

    private PostRepository postRepository;
    
    // GET /users
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return UserRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retriveUser(@PathVariable Integer id) {
        
        Optional<User> user = UserRepository.findById(id);
        
        if (user.isEmpty()) {
            throw new UserNotFoundException("id:"+id);
        }

        EntityModel<User> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        
        return entityModel;
    }

    // POST /user
    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user ) {
        User savedUser = UserRepository.save(user);

        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedUser.getId())
                        .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable Integer id) {

        Optional<User> user = UserRepository.findById(id);
        
        if (user.isEmpty()) {
            throw new UserNotFoundException("id:"+id);
        }

        return user.get().getPosts();
        
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostsForUser(
        @PathVariable Integer id,
        @Valid @RequestBody Post post) {

        Optional<User> user = UserRepository.findById(id);
        
        if (user.isEmpty()) {
            throw new UserNotFoundException("id:"+id);
        }

        post.setUser(user.get());

        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedPost.getId())
                        .toUri();

        return ResponseEntity.created(location).build();        
    }

    @DeleteMapping("/jpa/users/{id}")
    public void DeleteUser(@PathVariable Integer id) {
        
        UserRepository.deleteById(id);
    }

}
