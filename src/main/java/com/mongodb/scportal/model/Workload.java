package com.mongodb.scportal.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("workload")
@Getter @Setter @NoArgsConstructor @ToString @AllArgsConstructor
public class Workload {

		@Id
		private String id;

		private String name;
		private int quantity;
		private String currentDatabase;
	    private String targetCloud;
	    private String parentOrg;
	    private String description;
	    private String currentHosting;
		private String motion;
		private Boolean inProduction;
		private String dataStore;
		private String workloadType;
		private Date dateCreated;
		private Date lastEdited;
		private Org org;





		public Workload(String id, String name, int quantity, String currentDatabase) {
			super();
			this.id = id;
			this.name = name;
			this.quantity = quantity;
			this.currentDatabase = currentDatabase;
		}



}
