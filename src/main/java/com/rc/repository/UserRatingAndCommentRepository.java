package com.rc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.rc.entity.Recipe;
import com.rc.entity.UserRatingAndComment;

public interface UserRatingAndCommentRepository extends JpaRepository<UserRatingAndComment, Long>  {

	public boolean existsByUserMailAdressAndRecipe(String userMailAdress, Recipe recipe);
	
	// falls existsBy nicht funktioniert, dann:
//	public void findByUserMailAdressAndRecipe(String userMailAdress, Recipe recipe);
}
