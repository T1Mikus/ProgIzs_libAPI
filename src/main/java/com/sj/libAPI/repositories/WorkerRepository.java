package com.sj.libAPI.repositories;

import com.sj.libAPI.models.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkerRepository extends JpaRepository<Worker, UUID> {

    Worker findByEmail(String email);

}
