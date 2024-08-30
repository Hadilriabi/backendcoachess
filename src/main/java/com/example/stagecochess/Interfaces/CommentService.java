package com.example.stagecochess.Interfaces;

import com.example.stagecochess.Entities.Cmtr;

import java.util.List;

public interface CommentService {
    List<Cmtr> retrieveAllComments();

    Cmtr addComment(Cmtr comment);



    Cmtr addCommentEtAffecterAPost(Long postId, Cmtr comment);

    List<Cmtr> getCommentsByPostId(Long postId);
    Cmtr assignUserToComment(Long commentId, Long userId);

}
