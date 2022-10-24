package com.sj.libAPI.services;

import com.sj.libAPI.models.DTO.WorkerDTO;
import com.sj.libAPI.models.entities.User;
import com.sj.libAPI.models.entities.Worker;
import com.sj.libAPI.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository _workerRepository;

    private PasswordEncoder _encoder = new BCryptPasswordEncoder();

    public List<Worker> getAllWorkers() {
        return new ArrayList<>(_workerRepository.findAll());
    }

    public Worker getWorkerById(UUID id) {
        return _workerRepository.findById(id).orElse(null);
    }

    public void addWorker(WorkerDTO workerDTO){
        Worker newWorker = new Worker(workerDTO);
        newWorker.setCreatedAt(LocalDate.now());
        newWorker.setPassword(_encoder.encode(newWorker.getPassword()));
        _workerRepository.save(newWorker);
    }

    public void updateWorker(UUID id, WorkerDTO workerDTO){
        Worker updatedWorker = new Worker(workerDTO);
        updatedWorker.setId(id);
        updatedWorker.setLastUpdateDt(LocalDate.now());
        if(updatedWorker.getPassword() != null){
            updatedWorker.setPassword(_encoder.encode(updatedWorker.getPassword()));
            _workerRepository.save(updatedWorker);
            return;
        }
        updatedWorker.setPassword(Objects.requireNonNull(_workerRepository.findById(id).orElse(null)).getPassword());
        _workerRepository.save(updatedWorker);
    }

    public void deleteWorker(UUID id){
        _workerRepository.deleteById(id);
    }

}
