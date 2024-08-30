package com.example.stagecochess.Repository;


import com.example.stagecochess.Entities.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PostRepository extends CrudRepository<Post,Long> {


}
