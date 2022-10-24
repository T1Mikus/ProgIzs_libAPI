package com.sj.libAPI.services;

import com.sj.libAPI.models.DTO.LibraryDTO;
import com.sj.libAPI.models.entities.Library;
import com.sj.libAPI.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository _libraryRepository;

    public List<Library> getAllLibrarys() {
        return new ArrayList<>(_libraryRepository.findAll());
    }

    public Library getLibraryById(UUID id) {
        return _libraryRepository.findById(id).orElse(null);
    }

    public void addLibrary(LibraryDTO libraryDTO){
        Library newLibrary = new Library(libraryDTO);
        _libraryRepository.save(newLibrary);
    }

    public void updateLibrary(UUID id, LibraryDTO libraryDTO){
        Library updatedLibrary = new Library(libraryDTO);
        updatedLibrary.setId(id);
        _libraryRepository.save(updatedLibrary);
    }

    public void deleteLibrary(UUID id){
        _libraryRepository.deleteById(id);
    }

}
