package com.mongodb.scportal.repository;


import com.mongodb.client.result.UpdateResult;
import com.mongodb.scportal.model.Workload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class CustomItemRepositoryImpl implements CustomItemRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public void updateItemQuantity(String name, float newQuantity) {
		Query query = new Query(Criteria.where("name").is(name));
		Update update = new Update();
		update.set("quantity", newQuantity);
		
		UpdateResult result = mongoTemplate.updateFirst(query, update, Workload.class);
		
		if(result == null)
			System.out.println("No documents updated");
		else
			System.out.println(result.getModifiedCount() + " document(s) updated..");

	}

}
