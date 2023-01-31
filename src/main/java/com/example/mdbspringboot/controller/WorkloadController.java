package com.example.mdbspringboot.controller;

import com.example.mdbspringboot.model.Workload;
import com.example.mdbspringboot.repository.WorkloadRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
public class WorkloadController {
    private final WorkloadRepository repository;

    WorkloadController(WorkloadRepository repository) {
        this.repository = repository;
    }


    @PostMapping(
            value = "/workload", consumes = "application/json", produces = "application/json")
    public Workload createWorkload(@RequestBody Workload workload) {
        return repository.insert(workload);
    }

    @PostMapping(
            value = "/updateWorkload", consumes = "application/json", produces = "application/json")
    public Workload updateWorkloadById(@RequestBody Workload workload, HttpServletResponse response) {
        response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/findWorkload/" + workload.getId()).toUriString());
        return repository.save(workload);
    }


    @GetMapping(value = "/workload/id/{id}", consumes = "application/json", produces = "application/json")
    public Workload findWorkloadById(@PathVariable("id") String id, HttpServletResponse response) {
        Optional<Workload> workload = repository.findById(id);
        if (workload.isPresent()) {
            return workload.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }

    }

    @PostMapping(value = "/deleteworkloadById/id/{id}", consumes = "application/json", produces = "application/json")
    public void deleteWorkloadById(@PathVariable("id") String id) {
        repository.deleteById(id);
    }

    @GetMapping(value = "/findWorkloadByName/{name}", consumes = "application/json", produces = "application/json")
    public Workload getWorkloadByName(@PathVariable("name") String name) {
        Optional<Workload> workload = Optional.ofNullable(repository.findWorkloadByName(name));
        if (workload.isPresent()) {
            return workload.get();
        } else {
            throw new ResourceNotFoundException("Record not found with name : " + name);
        }

    }
}
