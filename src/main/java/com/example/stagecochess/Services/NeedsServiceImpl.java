package com.example.stagecochess.Services;

import com.example.stagecochess.Entities.Needs;
import com.example.stagecochess.Entities.Post;
import com.example.stagecochess.Entities.User;
import com.example.stagecochess.Interfaces.NeedsService;
import com.example.stagecochess.Repository.NeedsRepository;
import com.example.stagecochess.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NeedsServiceImpl implements NeedsService {
    NeedsRepository needsRepository;
    UserRepository userRepository;
    @Override
    public List<Needs> retrieveAllNeeds() {
        return (List<Needs>) needsRepository.findAll();

    }

    @Override
    public Needs addNeeds(Needs needs) {
        Needs savedNeeds = needsRepository.save(needs);
        log.info("Saved Needs ID: {}", savedNeeds.getNeedsId());
        return savedNeeds;
    }



    @Override
    public Needs updateNeeds(long idNeeds, Needs needs) {
        Needs existingNeeds = needsRepository.findById(idNeeds).orElse(null);
        if (existingNeeds != null) {
            needs.setNeedsId(idNeeds);
            return needsRepository.save(needs);
        }
        return null;
    }

    @Override
    public Needs retrieveNeeds(long idNeeds) {
        return needsRepository.findById(idNeeds).orElse(null);
    }

    @Override
    public void removeNeeds(long idNeeds) {
        needsRepository.deleteById(idNeeds);

    }

    @Transactional
    public Needs assignUserToNeeds(Long needsId, Long userId) {
        log.info("Assigning user with ID {} to needs with ID {}", userId, needsId);

        Needs needs = needsRepository.findById(needsId)
                .orElseThrow(() -> {
                    log.error("Needs with ID {} not found", needsId);
                    return new RuntimeException("Needs not found with ID: " + needsId);
                });

        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    log.error("User with ID {} not found", userId);
                    return new RuntimeException("User not found with ID: " + userId);
                });

        needs.setUser(user);

        log.info("Successfully assigned user with ID {} to needs with ID {}", userId, needsId);

        return needsRepository.save(needs);
    }


}

