package com.nnk.springboot.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.repositories.dto.RatingDTO;
import com.nnk.springboot.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService
{
	
	@Autowired RatingRepository ratingRepo;
	
	@Override
	public Rating create(RatingDTO ratingDTO)
	{
		Rating newRating = new Rating(
				ratingDTO.getMoodysRating(),
				ratingDTO.getSandPRating(),
				ratingDTO.getFitchRating(),
				ratingDTO.getOrderNumber());
		
		ratingRepo.save(newRating);
		
		return newRating;
	}

	
	
	@Override
	public Optional<RatingDTO> read(Integer id)
	{
		Rating rating = ratingRepo.findById(id).get();
		
		RatingDTO ratingDTO = new RatingDTO(
				rating.getId(),
				rating.getMoodysRating(),
				rating.getSandPRating(),
				rating.getFitchRating(),
				rating.getOrderNumber());
		
		return Optional.of(ratingDTO);
	}

	
	
	@Override
	public List<RatingDTO> readAll()
	{
		List<Rating> ratingList = ratingRepo.findAll();
		List<RatingDTO> ratingDTOList = new ArrayList<>();
		
		for (Rating rating : ratingList)
		{
			ratingDTOList.add( new RatingDTO(
					rating.getId(),
					rating.getMoodysRating(),
					rating.getSandPRating(),
					rating.getFitchRating(),
					rating.getOrderNumber()));
		}
		
		return ratingDTOList;
	}

	
	
	@Override
	public Rating update(Integer id, String moodysRating, String sandPRating, String fitchRating, Integer orderNumber)
	{
		Rating rating = ratingRepo.findById(id).get();
		
		rating.setMoodysRating(moodysRating);
		rating.setSandPRating(sandPRating);
		rating.setFitchRating(fitchRating);
		rating.setOrderNumber(orderNumber);
		
		ratingRepo.save(rating);
		
		return rating;
	}

	
	
	@Override
	public void delete(Integer id)
	{
		ratingRepo.deleteById(id);
		
	}

}
