package com.example.mdbspringboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Workload")
@Getter @Setter @NoArgsConstructor
public class Workload {

		@Id
		private ObjectId id;

		private String workloadName;
		private int quantity;
		private String currentDatabase;
	    private String targetCloud;
	    private String parentOrg;
	    private String description;
	    private String currentHosting;


		public Workload(ObjectId id, String workloadName, int quantity, String currentDatabase) {
			super();
			this.id = id;
			this.workloadName = workloadName;
			this.quantity = quantity;
			this.currentDatabase = currentDatabase;
		}



}
