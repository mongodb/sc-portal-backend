package com.example.mdbspringboot.repository;

import com.example.mdbspringboot.model.Workload;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface WorkloadRepository extends MongoRepository<Workload, String> {
	public long count();

	@Query("{workloadName:'?0'}")
	Workload findItemByWorkloadName(String name);
	
	@Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
	List<Workload> findAll(String category);
	


}
