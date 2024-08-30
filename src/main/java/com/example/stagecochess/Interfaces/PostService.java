package com.example.stagecochess.Interfaces;

import com.example.stagecochess.Entities.Post;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {
    Post addPost(Post post, MultipartFile file);


    List<Post> retrieveAllPosts();
    Post affecterCommentsAPost(long idPost, long idComment);
    Post assignUserToPost(Long postId, Long userId);
}
