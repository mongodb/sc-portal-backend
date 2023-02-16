package com.mongodb.scportal.repository;


import com.mongodb.scportal.model.Sizing;
import com.mongodb.scportal.model.Workload;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SizingRepository extends MongoRepository<Sizing, String> {
	 long count();

	//@Query("{name:'?0'}")


	@Query(value="{'workload.id':'?0'}")
	List<Sizing> findAll(String workloadId);


	@Query("{ 'id' : ?0, 'workload.id':  ?1}")
	Optional<Sizing> findById(String id, String workloadId);




}
