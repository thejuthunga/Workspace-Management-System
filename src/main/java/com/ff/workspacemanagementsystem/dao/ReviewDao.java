package com.ff.workspacemanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ff.workspacemanagementsystem.entity.Branch;
import com.ff.workspacemanagementsystem.entity.Review;
import com.ff.workspacemanagementsystem.exception.IdNotFoundException;
import com.ff.workspacemanagementsystem.repository.BranchRepository;
import com.ff.workspacemanagementsystem.repository.ReviewRepository;

@Repository
public class ReviewDao {
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private BranchRepository branchRepository;
	
	//save Review
	public List<Review> saveReview(int id,Review review) {
		Optional<Branch> opt=branchRepository.findById(id);
		if(opt.isPresent()) {
			Branch branch=opt.get();
			List<Review> reviews=branch.getReviews();
			reviews.add(review);
			branch.setReviews(reviews);
			reviewRepository.save(review);
			branchRepository.save(branch);
			
			return reviews;
		}
		else {
			throw new IdNotFoundException("ID: " + id + " Not Found");
		}
	}
	
	//get review
	public List<Review> getReview(int b_id){
		Optional<Branch> opt=branchRepository.findById(b_id);
		if(opt.isPresent()) {
			return opt.get().getReviews();
		}
		else {
			throw new IdNotFoundException("ID: " + b_id + " Not Found");
		}
	}
	
	//delete Review
	public Review deleteReview(int b_id,int r_id) {
		Optional<Branch> opt=branchRepository.findById(b_id);
		if(opt.isPresent()) {
			Review review=null;
			Branch branch=opt.get();
			List<Review> reviews=branch.getReviews();
			for(Review r:reviews) {
				if(r.getReviewid()==r_id) {
					review=r;
					break;
				}
			}
			if(review != null && review instanceof Review) {
				reviews.remove(review);
				branch.setReviews(reviews);
				branchRepository.save(branch);
				reviewRepository.delete(review);
			}
			return review;
		}
		else {
			throw new IdNotFoundException("ID: " + b_id + " Not Found");
		}
	}
	
	//update Review
	public Review updateReview(int b_id,int r_id,Review review) {
		Optional<Branch> opt=branchRepository.findById(b_id);
		if(opt.isPresent()) {
			Branch b=opt.get();
			List<Review> reviews=b.getReviews();
			for(Review r:reviews) {
				if(r.getReviewid()==r_id) {
					reviewRepository.save(review);
				}
			}
			return null;
		}
		else {
			throw new IdNotFoundException("ID: " + b_id + " Not Found");
		}
	}
}
