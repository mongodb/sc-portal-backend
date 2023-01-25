package com.example.mdbspringboot.controller;

import com.example.mdbspringboot.model.Workload;
import com.example.mdbspringboot.repository.WorkloadRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

@RestController
public class WorkloadController {
    private final WorkloadRepository repository;

    WorkloadController(WorkloadRepository repository){
        this.repository=repository;
    }

    @PostMapping("/saveworload")
    Workload newWorkload(@RequestBody Workload workload) {
        return repository.save(workload);
    }

    @PostMapping(
            value = "/createWorkload", consumes = "application/json", produces = "application/json")
    public Workload createWorkload(@RequestBody Workload workload) {
        return repository.insert(workload);
    }

    @PostMapping(
            value = "/updateWorkload", consumes = "application/json", produces = "application/json")
    public Workload updateWorkload(@RequestBody Workload workload, HttpServletResponse response) {
        response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/findWorkload/" + workload.getId()).toUriString());

        return repository.save(workload);
    }

}
