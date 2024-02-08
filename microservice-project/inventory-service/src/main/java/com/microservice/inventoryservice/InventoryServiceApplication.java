package com.microservice.inventoryservice;

import com.microservice.inventoryservice.model.Inventory;
import com.microservice.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
		var inventory = new	Inventory();
		inventory.setSkuCode("iPhone-14");
		inventory.setQuantity(100);

		var inventory1 = new	Inventory();
		inventory1.setSkuCode("iPhone-14");
		inventory1.setQuantity(0);

		inventoryRepository.save(inventory);
		inventoryRepository.save(inventory1);
		};
	}

}
