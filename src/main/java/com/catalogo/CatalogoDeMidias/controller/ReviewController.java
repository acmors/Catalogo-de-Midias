package com.catalogo.CatalogoDeMidias.controller;

import com.catalogo.CatalogoDeMidias.model.Review;
import com.catalogo.CatalogoDeMidias.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public Review createReview(Review review){
        return reviewService.createReview(review);
    }

    @GetMapping
    public List<Review> listAllReview(){
        return reviewService.listAllReview();
    }

    @GetMapping("/{id}")
    public Review findById(@PathVariable Long id){
        return reviewService.findById(id);
    }

    @PutMapping("/{id}")
    public Review updateReview(@RequestBody Review review, @PathVariable Long id){
        return reviewService.updateReview(review, id);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id){
        reviewService.deleteReview(id);
    }
}
