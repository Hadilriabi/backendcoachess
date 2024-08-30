package com.example.stagecochess.Controllers;


import com.example.stagecochess.Entities.Cmtr;
import com.example.stagecochess.Entities.Post;
import com.example.stagecochess.Interfaces.CommentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/comments")
public class CommentController {
    CommentService commentService;

    @PostMapping("/addComment")
    public Cmtr addComment(@RequestBody Cmtr comment) {
        log.info("Received comment: {}", comment);
        Cmtr savedComment = commentService.addComment(comment);
        log.info("Saved comment: {}", savedComment);
        return savedComment;
    }


    @GetMapping("/retrieveAllComments")
    public List<Cmtr> retrieveAllComments() {
        return commentService.retrieveAllComments();
    }


    @PostMapping("/addCommentToPost/{postId}")
    public ResponseEntity<Cmtr> addCommentToPost(@PathVariable Long postId,
                                                 @RequestBody Cmtr comment) {
        // Associer le commentaire au post et le sauvegarder
        Cmtr newComment = commentService.addCommentEtAffecterAPost(postId, comment);

        // Retourner une réponse HTTP avec le commentaire nouvellement créé
        return ResponseEntity.ok(newComment);
    }




    @GetMapping("/getCommentsByPostId/{postId}")
    public ResponseEntity<List<Cmtr>> getCommentsByPostId(@PathVariable Long postId) {
        List<Cmtr> comments = commentService.getCommentsByPostId(postId);
        return ResponseEntity.ok(comments);
    }

    @PostMapping("/{commentId}/assignUserToComment/{userId}")
    public ResponseEntity<Cmtr> assignUserToComment(@PathVariable Long commentId, @PathVariable Long userId) {
        Cmtr updatedComment = commentService.assignUserToComment(commentId, userId);
        return ResponseEntity.ok(updatedComment);
    }

}
