package com.catalogo.CatalogoDeMidias.service;

import com.catalogo.CatalogoDeMidias.exceptions.ResourceNotFound;
import com.catalogo.CatalogoDeMidias.model.Review;
import com.catalogo.CatalogoDeMidias.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review createReview(Review review){
        return reviewRepository.save(review);
    }

    public List<Review> listAllReview(){
        return reviewRepository.findAll();
    }

    public Review findById(Long id){
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Review não encontrada."));
    }

    public Review updateReview(Review reviewUpdated, Long id){
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Review não encontrada."));

        review.setMedia(reviewUpdated.getMedia());
        review.setUserName(reviewUpdated.getUserName());
        review.setComment(reviewUpdated.getComment());
        review.setScore(reviewUpdated.getScore());

        return reviewRepository.save(review);

    }

    public void deleteReview(Long id){
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Review não encontrado."));
        reviewRepository.delete(review);
    }
}
