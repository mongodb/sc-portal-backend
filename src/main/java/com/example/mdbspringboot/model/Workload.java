package com.example.mdbspringboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("workload")
@Getter @Setter @NoArgsConstructor @ToString
public class Workload {

		@Id
		private String id;

		private String workloadName;
		private int quantity;
		private String currentDatabase;
	    private String targetCloud;
	    private String parentOrg;
	    private String description;
	    private String currentHosting;


		public Workload(String id, String workloadName, int quantity, String currentDatabase) {
			super();
			this.id = id;
			this.workloadName = workloadName;
			this.quantity = quantity;
			this.currentDatabase = currentDatabase;
		}



}
