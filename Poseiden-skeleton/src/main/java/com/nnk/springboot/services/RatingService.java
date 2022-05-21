package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.dto.RatingDTO;

public interface RatingService
{
	public Rating create (RatingDTO ratingDTO);
	public Optional<RatingDTO> read (Integer id);
	public List<RatingDTO> readAll();
	public Rating update(Integer id, RatingDTO ratingDTO);
	public void delete (Integer id);
	
	

}
