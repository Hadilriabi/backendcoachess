package com.example.stagecochess.Repository;

import com.example.stagecochess.Entities.Needs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface NeedsRepository extends CrudRepository<Needs,Long> {
}
