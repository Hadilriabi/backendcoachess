package com.example.stagecochess.Interfaces;

import com.example.stagecochess.Entities.Needs;

import java.util.List;

public interface NeedsService {
    List<Needs> retrieveAllNeeds();

    Needs addNeeds(Needs needs);

    Needs updateNeeds(long idNeeds, Needs needs);

    Needs retrieveNeeds(long idNeeds);

    void removeNeeds(long idNeeds);
    Needs assignUserToNeeds(Long NeedsId, Long userId);
}
