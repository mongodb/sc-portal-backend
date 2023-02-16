package com.mongodb.scportal.service;

import com.mongodb.scportal.model.Sizing;
import com.mongodb.scportal.repository.SizingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizingService {


        @Autowired
        private SizingRepository repository;

        @Autowired
        MongoTemplate mongoTemplate;

        public List<Sizing> getSizingsByWorkload(String workloadId) {
            return repository.findAll(workloadId);
        }

        public Optional<Sizing> findById(String id, String workloadId) {
            return repository.findById(id, workloadId);
        }

        public Sizing createSizing(Sizing sizing) {
            return repository.insert(sizing);
        }

    /**
     * I don't like this method as I would prefer we use the $set operator to avoid the replace action
     * @param sizing
     * @return
     */
    public Sizing updateSizing(Sizing sizing) {
            return repository.save(sizing);
        }



}
