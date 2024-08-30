package com.example.stagecochess.Repository;

import com.example.stagecochess.Entities.Cmtr;
import com.example.stagecochess.Entities.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CommentRepository extends CrudRepository<Cmtr,Long> {

    // Trouver les commentaires par post (relation)
    List<Cmtr> findByPost(Post post);
}
