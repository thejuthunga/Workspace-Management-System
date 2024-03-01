package com.ff.workspacemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ff.workspacemanagementsystem.dto.ResponseStructure;
import com.ff.workspacemanagementsystem.entity.Review;
import com.ff.workspacemanagementsystem.service.ReviewService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	//save Review
	@Operation(description = "Add Review",summary = "add review")
	@ApiResponse(description = "Review Added",responseCode = "201")
	@PostMapping("client_id/{u_id}branch_id/{b_id}")
	public ResponseEntity<ResponseStructure<List<Review>>> saveReview(@PathVariable int u_id,@PathVariable int b_id,@RequestBody Review review){
		return reviewService.saveReview(u_id,b_id, review);
	}
	
	//Get Review
	@Operation(description = "Find Review",summary = "find review")
	@ApiResponse(description = "Found",responseCode = "302")
	@GetMapping("branch_id/{b_id}")
	public ResponseEntity<ResponseStructure<List<Review>>> getReview(@PathVariable int b_id){
		return reviewService.getReview(b_id);
	}
	
	//Update review
	@Operation(description = "Edit Review",summary = "editreview")
	@ApiResponse(description = "OK",responseCode = "200")
	@PutMapping("branch_id/{b_id}/review_id/{r_id}")
	public ResponseEntity<ResponseStructure<Review>> updateReview(@PathVariable int b_id,@PathVariable int r_id,@RequestBody Review review){
		return reviewService.updateReview(b_id, r_id, review);
	}
	
	//Delete Review
	@Operation(description = "Delete Review",summary = "delete review")
	@ApiResponse(description = "OK",responseCode = "200")
	@DeleteMapping("branch_id/{b_id}/review_id/{r_id}")
	public ResponseEntity<ResponseStructure<Review>> deleteReview(@PathVariable int b_id,@PathVariable int r_id){
		return reviewService.deleteReview(b_id, r_id);
	}
	

}
