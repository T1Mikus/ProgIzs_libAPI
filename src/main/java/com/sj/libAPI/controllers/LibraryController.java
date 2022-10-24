package com.sj.libAPI.controllers;

import com.sj.libAPI.models.DTO.LibraryDTO;
import com.sj.libAPI.models.entities.Library;
import com.sj.libAPI.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

    @Autowired
    private LibraryService _libraryService;

    @GetMapping
    public List<Library> getAllLibrarys() {
        return _libraryService.getAllLibrarys();
    }

    @GetMapping("{id}")
    public Library getLibraryById(@PathVariable UUID id){
        return _libraryService.getLibraryById(id);
    }

    @PostMapping
    public void addLibrary(@RequestBody LibraryDTO libraryDTO){
        _libraryService.addLibrary(libraryDTO);
    }

    @PutMapping("{id}")
    public void updateLibrary(@PathVariable UUID id, @RequestBody LibraryDTO libraryDTO){
        _libraryService.updateLibrary(id, libraryDTO);
    }

    @DeleteMapping("{id}")
    public void deleteLibrary(@PathVariable UUID id){
        _libraryService.deleteLibrary(id);
    }

}
