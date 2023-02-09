package com.example.mdbspringboot.service;

import com.example.mdbspringboot.model.Workload;
import com.example.mdbspringboot.repository.WorkloadRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class WorkloadService {


    @Autowired
    private WorkloadRepository repository;

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Workload> findWorkloadByName(String name){
        return repository.findWorkloadByName(name);
    }


    public List<Workload> findAll(String category) {
        return repository.findAll(category);
    }


    public Workload insert(Workload workload) {
        return repository.insert(workload);
    }

    public Workload findWorkloadObjectId(String objectId){
        return repository.findWorkloadObjectId(objectId);
    }

    public Workload save(Workload workload){
        return repository.save(workload);
    }

    public Optional<Workload> findById(String id){
        return repository.findById(id);
    }

    public void deleteById(String id){
        repository.deleteById(id);
    }

    public Boolean updateWorkload( String id, Map<String, Object> fields){
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        for (String key : fields.keySet()) {
            update.set("key", fields.get(key));
        }
        UpdateResult result = mongoTemplate.updateFirst(query, update, Workload.class);
        return result.wasAcknowledged();
    }




}
