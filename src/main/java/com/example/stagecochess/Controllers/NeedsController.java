package com.example.stagecochess.Controllers;


import com.example.stagecochess.Entities.Needs;
import com.example.stagecochess.Entities.Post;
import com.example.stagecochess.Interfaces.NeedsService;
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

@RequestMapping("api/needs")
public class NeedsController {

    NeedsService needsService;
    @PostMapping("/addNeeds")
    public ResponseEntity<Needs> addNeeds(@RequestBody Needs needs) {
        log.info("Received Needs: {}", needs.getListOfNeeds());
        Needs savedNeeds = needsService.addNeeds(needs);
        log.info("Saved Needs ID: {}", savedNeeds.getNeedsId());
        return ResponseEntity.ok(savedNeeds);
    }

    @PutMapping("/updateNeeds/{idNeeds}")
    public Needs updateNeeds(@PathVariable("idNeeds") long idNeeds, @RequestBody Needs needs) {
        return needsService.updateNeeds(idNeeds,needs);
    }

    @GetMapping("/retrieveNeeds/{idNeeds}")
    public  Needs retrieveNeeds(@PathVariable("idNeeds") long idNeeds) {
        return needsService.retrieveNeeds(idNeeds);
    }
    @DeleteMapping("/removeNeeds/{idNeeds}")
    public void removeNeeds(@PathVariable("idNeeds") long idNeeds) {
        needsService.removeNeeds(idNeeds);
    }
    @GetMapping("/retrieveAllNeeds")
    public List<Needs> retrieveAllNeeds() {
        return needsService.retrieveAllNeeds();
    }



    @PostMapping("/{needsId}/assignUserToNeeds/{userId}")
    public ResponseEntity<Needs> assignUserToNeeds(@PathVariable Long needsId, @PathVariable Long userId) {
        Needs updatedNeeds = needsService.assignUserToNeeds(needsId, userId);
        return ResponseEntity.ok(updatedNeeds);
    }

}

