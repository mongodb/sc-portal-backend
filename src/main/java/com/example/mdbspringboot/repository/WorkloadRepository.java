package com.example.mdbspringboot.repository;

import com.example.mdbspringboot.model.Workload;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WorkloadRepository extends MongoRepository<Workload, String> {
	 long count();

	//@Query("{name:'?0'}")
	@Aggregation(pipeline = {"{'$search': {'index':'default','text': {'path': ['name','org.name'], 'query': '?0'}}}"})
	List<Workload> findWorkloadByName(String name);
	
	@Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
	List<Workload> findAll(String category);


	@Query("{workloadObjectId:'?0'}")//
	Workload findWorkloadObjectId(String objectId);

	@Query("{ 'id' : ?0 }")
	Optional<Workload> findById(String id);




}
