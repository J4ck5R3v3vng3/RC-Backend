package com.rc.service;

import org.springframework.stereotype.Service;

import com.rc.entity.UserRatingAndComment;
import com.rc.repository.UserRatingAndCommentRepository;

@Service
public class UserRatingAndCommentService {

	private final UserRatingAndCommentRepository userRatingAndCommentRepository;

	public UserRatingAndCommentService(UserRatingAndCommentRepository userRatingAndCommentRepository) {
		this.userRatingAndCommentRepository = userRatingAndCommentRepository;
	}

}
