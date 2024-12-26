package com.monkmaze.ecommerce.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PurchaseController {

	@PostMapping("/buy/{product_id}")
	public ResponseEntity<?> buyProduct(@PathVariable Long product_id) {

		Map<String, Object> response = new HashMap<>();
		response.put("message", "Purchase successful");
		response.put("product_id", product_id);

		return ResponseEntity.ok(response);
	}

}
