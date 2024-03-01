package com.ff.workspacemanagementsystem.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ff.workspacemanagementsystem.dao.ReviewDao;
import com.ff.workspacemanagementsystem.dto.ResponseStructure;
import com.ff.workspacemanagementsystem.entity.Review;

@Service
public class ReviewService {
	@Autowired
	private ReviewDao reviewDao;
	
	//save Review
	public ResponseEntity<ResponseStructure<List<Review>>> saveReview(int u_id,int b_id,Review review){
		List<Review> reviews=reviewDao.saveReview(u_id,b_id,review);
		
		ResponseStructure<List<Review>> responseStructure = new ResponseStructure<List<Review>>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage(HttpStatus.CREATED.getReasonPhrase());
		responseStructure.setData(reviews);
		
		return new ResponseEntity<ResponseStructure<List<Review>>>(responseStructure,HttpStatus.CREATED);
	}
	
	//get Review
	public ResponseEntity<ResponseStructure<List<Review>>> getReview(int b_id){
		List<Review> reviews=reviewDao.getReview(b_id);
		
		ResponseStructure<List<Review>> responseStructure = new ResponseStructure<List<Review>>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage(HttpStatus.FOUND.getReasonPhrase());
		responseStructure.setData(reviews);
		
		return new ResponseEntity<ResponseStructure<List<Review>>>(responseStructure,HttpStatus.FOUND);	
	}
	
	//delete Review
	public ResponseEntity<ResponseStructure<Review>> deleteReview(int b_id,int r_id){
		Review review=reviewDao.deleteReview(b_id, r_id);
		
		ResponseStructure<Review> responseStructure = new ResponseStructure<Review>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage(HttpStatus.OK.getReasonPhrase());
		responseStructure.setData(review);
		
		return new ResponseEntity<ResponseStructure<Review>>(responseStructure,HttpStatus.OK);	
	}
	
	//update Review
	public ResponseEntity<ResponseStructure<Review>> updateReview(int b_id,int r_id,Review revieww){
		Review review=reviewDao.updateReview(b_id, r_id, revieww);
		
		ResponseStructure<Review> responseStructure = new ResponseStructure<Review>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage(HttpStatus.OK.getReasonPhrase());
		responseStructure.setData(review);
		
		return new ResponseEntity<ResponseStructure<Review>>(responseStructure,HttpStatus.OK);	
	}
}
