package com.mongodb.scportal.repository;


import com.mongodb.scportal.model.Workload;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WorkloadRepository extends MongoRepository<Workload, String> {
	 long count();

	//@Query("{name:'?0'}")
	@Aggregation(pipeline = {"{'$search': {'index':'default','text': {'path': ['name','org.name'], 'query': '?0'}}}"})
	List<Workload> findWorkloadByName(String name);

	@Aggregation(pipeline = {"{'$match': {}},{'$sort': {'lastUpdate':-1}},{'$limit': 50}]"})
	List<Workload> findRecentWorkloads();


	@Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
	List<Workload> findAll(String category);


	@Query("{workloadObjectId:'?0'}")//
	Workload findWorkloadObjectId(String objectId);

	@Query("{ 'id' : ?0 }")
	Optional<Workload> findById(String id);




}
