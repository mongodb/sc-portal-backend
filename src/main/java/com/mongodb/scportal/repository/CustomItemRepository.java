package com.mongodb.scportal.repository;

public interface CustomItemRepository {
	
	void updateItemQuantity(String itemName, float newQuantity);

}
