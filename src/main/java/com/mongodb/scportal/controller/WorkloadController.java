package com.mongodb.scportal.controller;

import com.mongodb.scportal.model.Sizing;
import com.mongodb.scportal.model.Workload;
import com.mongodb.scportal.service.SizingService;
import com.mongodb.scportal.service.WorkloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://sc-portal.sc-north.staging.corp.mongodb.com"}, maxAge = 3600)
@RequestMapping(value="workload", consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class WorkloadController {

    @Autowired
    private WorkloadService service;

    @Autowired
    private SizingService sizingService;



    @PostMapping
    public Workload createWorkload(@RequestBody Workload workload) {
        return service.insert(workload);
    }

    @PutMapping(value = "/{id}")
    public Workload updateWorkloadById(@PathVariable("id") String id, @RequestBody Workload workload, HttpServletResponse response) {
        response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/workload/" + workload.getId()).toUriString());
        workload.setId(id);
        return service.save(workload);
    }


    @GetMapping(value = "/{id}")
    public Workload findWorkloadById(@PathVariable("id") String id, HttpServletResponse response) {
        Optional<Workload> workload = service.findById(id);
        if (workload.isPresent()) {
            return workload.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }

    }

    @DeleteMapping(value = "/{id}")
    public void deleteWorkloadById(@PathVariable("id") String id) {
        service.deleteById(id);
    }

    /**
    Moved this to a post to make it easier to support additional fields in the future without having to change the URL signature.
    Also this format works better for free form names so we don't have to worry about URl encoding messing with things.
     */
    @PostMapping(value = "/search")
    public List<Workload> getWorkloadByName(@RequestBody String name) {
        Optional<List<Workload>> workload = Optional.ofNullable(service.findWorkloadByName(name));
        if (workload.isPresent()) {
            return workload.get();
        } else {
            return null;
            // Not returning an error here as its valid for a search to not return results.
            //throw new ResourceNotFoundException("Record not found with name : " + name);
        }

    }

    @PostMapping(value = "/recent")
    public List<Workload> getRecentWorkloads() {
        Optional<List<Workload>> workload = Optional.ofNullable(service.findRecentWorkloads());
        if (workload.isPresent()) {
            return workload.get();
        } else {
            return null;
            // Not returning an error here as its valid for a search to not return results.
            //throw new ResourceNotFoundException("Record not found with name : " + name);
        }

    }


    @GetMapping(value = "/{id}/sizing/{sizing_id}")
    public Sizing getSizingById(@PathVariable("id") String workloadId, @PathVariable("sizing_id") String sizingId, HttpServletResponse response) {
        Optional<Sizing> workload = sizingService.findById(sizingId, workloadId);
        if (workload.isPresent()) {
            return workload.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + sizingId + " for workload " + workloadId );
        }

    }

    @GetMapping(value = "/{id}/sizing")
    public List<Sizing> getAllSizingsForWorkload(@PathVariable("id") String workloadId,  HttpServletResponse response) {
        return sizingService.getSizingsByWorkload(workloadId);
    }


}
