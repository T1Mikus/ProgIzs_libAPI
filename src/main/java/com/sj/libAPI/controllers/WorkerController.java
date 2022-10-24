package com.sj.libAPI.controllers;

import com.sj.libAPI.models.DTO.WorkerDTO;
import com.sj.libAPI.models.entities.Worker;
import com.sj.libAPI.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    @Autowired
    private WorkerService _workerService;

    @GetMapping
    public List<Worker> getAllWorkers() {
        return _workerService.getAllWorkers();
    }

    @GetMapping("{id}")
    public Worker getWorkerById(@PathVariable UUID id){
        return _workerService.getWorkerById(id);
    }

    @PostMapping
    public void addWorker(@RequestBody WorkerDTO workerDTO){
        _workerService.addWorker(workerDTO);
    }

    @PutMapping("{id}")
    public void updateWorker(@PathVariable UUID id, @RequestBody WorkerDTO workerDTO){
        _workerService.updateWorker(id, workerDTO);
    }

    @DeleteMapping("{id}")
    public void deleteWorker(@PathVariable UUID id){
        _workerService.deleteWorker(id);
    }

}
