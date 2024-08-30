package com.example.stagecochess.Services;

import com.example.stagecochess.Entities.Cmtr;
import com.example.stagecochess.Entities.Post;
import com.example.stagecochess.Entities.User;
import com.example.stagecochess.Interfaces.PostService;
import com.example.stagecochess.Repository.CommentRepository;
import com.example.stagecochess.Repository.PostRepository;
import com.example.stagecochess.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.stream.events.Comment;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostServiceImpl implements PostService {
    PostRepository postRepository;
    UserRepository userRepository;

    CommentRepository commentRepository;
    public static String uploadDirectory = "C:/xampp/htdocs/hadilprojet/";
    @Override
    public Post addPost(Post post, MultipartFile file) {
        try {
            Path directoryPath = Paths.get(uploadDirectory);
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }
            String originalFilename = file.getOriginalFilename();
            String fileName = UUID.randomUUID().toString() + "_" + originalFilename;
            Path filePath = Paths.get(uploadDirectory, fileName);
            Files.write(filePath, file.getBytes());
            // Construire l'URL de l'image
            String imageUrl = fileName;
            // Définir l'URL de l'image sur l'objet Post
            post.setImagepost(imageUrl);
            // Ajouter le Post à la base de données
            return postRepository.save(post);
        } catch (IOException e) {
            log.error("Error occurred while adding funeral location:", e);
            return null; // Gérer l'erreur de manière appropriée dans votre application
        }
    }


    @Override
    public List<Post> retrieveAllPosts() {
        return (List<Post>) postRepository.findAll();
    }

    @Transactional
    public Post affecterCommentsAPost(long idPost, long idComment) {
        Post post = postRepository.findById(idPost).orElse(null);
        Cmtr comment = commentRepository.findById(idComment).orElse(null);

        if (post != null && comment != null) {
            List<Cmtr> comments = post.getComments();
            if (comments == null) {
                comments = new ArrayList<>();
            }
            comments.add(comment);
            post.setComments(comments);
        }
        return postRepository.save(post);
    }


    @Transactional

    public Post assignUserToPost(Long postId, Long userId) {
        // Trouver le post par son ID
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));

        // Trouver l'utilisateur par son ID
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // Assigner l'utilisateur au post
        post.setUser(user);

        // Sauvegarder le post avec l'utilisateur assigné
        return postRepository.save(post);
    }
}
