package com.example.stagecochess.Controllers;


import com.example.stagecochess.Entities.Post;
import com.example.stagecochess.Interfaces.PostService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)

@RequestMapping("api/posts")
public class PostController {

    PostService postService;
    @PostMapping("/addPost")
    public Post addPost(@ModelAttribute Post post, @RequestParam("image") MultipartFile file) {
        return postService.addPost(post,file);
    }

    @GetMapping("/retrieveAllPosts")
    public List<Post> retrieveAllPosts() {
        return postService.retrieveAllPosts();
    }

    @PostMapping("/{idPost}/comments/{idComment}")
    public Post affecterCommentsAPost(@PathVariable long idPost, @PathVariable long idComment) {
        return postService.affecterCommentsAPost(idPost, idComment);
    }


    @PostMapping("/{postId}/assignUser/{userId}")
    public ResponseEntity<Post> assignUserToPost(@PathVariable Long postId, @PathVariable Long userId) {
        Post updatedPost = postService.assignUserToPost(postId, userId);
        return ResponseEntity.ok(updatedPost);
    }


}
