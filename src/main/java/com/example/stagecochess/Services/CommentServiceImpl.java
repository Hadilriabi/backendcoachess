package com.example.stagecochess.Services;


import com.example.stagecochess.Entities.Cmtr;
import com.example.stagecochess.Entities.Post;
import com.example.stagecochess.Entities.User;
import com.example.stagecochess.Interfaces.CommentService;
import com.example.stagecochess.Repository.CommentRepository;
import com.example.stagecochess.Repository.PostRepository;
import com.example.stagecochess.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentServiceImpl implements CommentService {
    CommentRepository commentRepository;
    PostRepository postRepository;
    UserRepository userRepository;
    @Override
    public List<Cmtr> retrieveAllComments() {
        return (List<Cmtr>) commentRepository.findAll();

    }

    @Override
    public Cmtr addComment(Cmtr comment) {
        return commentRepository.save(comment);
    }




    @Override
    public Cmtr addCommentEtAffecterAPost(Long postId, Cmtr comment) {
        // Associer le commentaire au post
        comment.setPost(postRepository.findById(postId).orElse(null));

        // Sauvegarder le commentaire
        return commentRepository.save(comment);
    }


    public List<Cmtr> getCommentsByPostId(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        return commentRepository.findByPost(post);
    }

    @Transactional

    public Cmtr assignUserToComment(Long commentId, Long userId) {
        // Trouver le post par son ID
        Cmtr comment = commentRepository.findById(commentId).orElseThrow(() -> new RuntimeException("Post not found"));

        // Trouver l'utilisateur par son ID
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // Assigner l'utilisateur au post
        comment.setUser(user);

        // Sauvegarder le post avec l'utilisateur assigné
        return commentRepository.save(comment);
    }
}
