package com.ff.workspacemanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ff.workspacemanagementsystem.entity.Branch;
import com.ff.workspacemanagementsystem.entity.Review;
import com.ff.workspacemanagementsystem.entity.Users;
import com.ff.workspacemanagementsystem.exception.IdNotFoundException;
import com.ff.workspacemanagementsystem.repository.BranchRepository;
import com.ff.workspacemanagementsystem.repository.ReviewRepository;
import com.ff.workspacemanagementsystem.repository.UsersRepository;
import com.ff.workspacemanagementsystem.utility.UsersRole;

@Repository
public class ReviewDao {
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private BranchRepository branchRepository;
	@Autowired
	private UsersRepository userRepository;

	// save Review
	public List<Review> saveReview(int u_id, int id, Review review) {
		Optional<Users> opt = userRepository.findById(u_id);
		if (opt.isPresent()) {
			Users users = opt.get();
			if (users.getUsersRole() == UsersRole.CLIENT) {
				Optional<Branch> b_opt = branchRepository.findById(id);
				if (b_opt.isPresent()) {
					Branch branch = b_opt.get();
					List<Review> reviews = branch.getReviews();
					reviews.add(review);
					branch.setReviews(reviews);
					review.setBranch(branch);
					reviewRepository.save(review);
					branchRepository.save(branch);

					return reviews;
				} else {
					throw new IdNotFoundException("ID: " + id + " Not Found");
				}
			}

		}
		throw new NullPointerException("ID: " + u_id + " is not client");

	}

	// get review
	public List<Review> getReview(int b_id) {
		Optional<Branch> opt = branchRepository.findById(b_id);
		if (opt.isPresent()) {
			return opt.get().getReviews();
		} else {
			throw new IdNotFoundException("ID: " + b_id + " Not Found");
		}
	}

	// delete Review
	public Review deleteReview(int b_id, int r_id) {
		Optional<Branch> opt = branchRepository.findById(b_id);
		if (opt.isPresent()) {
			Review review = null;
			Branch branch = opt.get();
			List<Review> reviews = branch.getReviews();
			for (Review r : reviews) {
				if (r.getReviewid() == r_id) {
					review = r;
					break;
				}
			}
			if (review != null && review instanceof Review) {
				reviews.remove(review);
				branch.setReviews(reviews);
				branchRepository.save(branch);
				reviewRepository.delete(review);
			}
			return review;
		} else {
			throw new IdNotFoundException("ID: " + b_id + " Not Found");
		}
	}

	// update Review
	public Review updateReview(int b_id, int r_id, Review review) {
		Optional<Branch> opt = branchRepository.findById(b_id);
		Review rev = null;
		if (opt.isPresent()) {
			Branch b = opt.get();
			List<Review> reviews = b.getReviews();
			for (Review r : reviews) {
				if (r.getReviewid() == r_id) {
					r.setReviewid(r.getReviewid());
					r.setFeedback(review.getFeedback());
					r.setRating(review.getRating());
					r.setBranch(r.getBranch());
					reviewRepository.save(r);
					rev = r;
				}
			}
			return rev;
		} else {
			throw new IdNotFoundException("ID: " + b_id + " Not Found");
		}
	}
}
