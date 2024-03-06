package com.ff.workspacemanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ff.workspacemanagementsystem.dao.ReviewDao;
import com.ff.workspacemanagementsystem.entity.Branch;
import com.ff.workspacemanagementsystem.entity.Review;
import com.ff.workspacemanagementsystem.exception.IdNotFoundException;
import com.ff.workspacemanagementsystem.repository.BranchRepository;
import com.ff.workspacemanagementsystem.repository.ReviewRepository;

@SpringBootTest(classes = WorkspaceManagementSystemApplication.class)
public class ReviewTests {

	@Autowired
	private ReviewDao reviewdao;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Test
	public void reviewSaveTest() {
		Review review = new Review();
		review.setFeedback("good");
		review.setRating(4.5);
		
		
		assertEquals(review, reviewRepository.save(review));
	}
	
	@Test
	public void findByIdReview() {
		Optional<Review> opt_review = reviewRepository.findById(250);
		if(opt_review.isPresent()) {
			Review r=opt_review.get();
			assertEquals(250, r.getReviewid());
		}
	}
	
	@Test
	public void findAllReview() {
		
		
			assertThrows(IdNotFoundException.class, new Executable() {
				
				@Override
				public void execute() throws Throwable {
					List<Review> review= reviewRepository.findAll();
					Optional<Review> r=reviewRepository.findById(255);
					
						if(r.isPresent()) {
							if(review.contains(r.get())) {
								assertTrue(true);
							}
							else {
								throw new IdNotFoundException();
							}
							
						}
					
				}
			});
	}
	
	@Test
	public void deleteReview() {
		reviewRepository.deleteById(253);
		List<Review> r=reviewRepository.findAll();
		if(!r.contains(reviewRepository.findById(250))) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void updateReview() {
		Review review=new Review();
		review.setReviewid(250);
		review.setFeedback("bad and worst");
		review.setRating(1);
		review.setBranch(null);
		
		assertEquals(review.toString(), reviewRepository.save(review).toString());
	}
}
