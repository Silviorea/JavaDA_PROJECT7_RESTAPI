package com.nnk.springboot.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.repositories.dto.BidListDTO;
import com.nnk.springboot.repositories.dto.UserDTO;
import com.nnk.springboot.services.BidListService;

/**
 * Implementation of BidList Service Interface.
 * All of the CRUD methods are defined here
 * @author Silvio
 *
 */

@Service
public class BidListServiceImpl implements BidListService
{

	@Autowired
	private BidListRepository bidListRepository;

	
	
	@Override
	public BidList create(BidListDTO bidListDTO)
	{
		BidList newBidList = new BidList(
				bidListDTO.getAccount(), 
				bidListDTO.getType(), 
				bidListDTO.getBidQuantity());
		bidListRepository.save(newBidList);
		
		return newBidList;
	}
	
	

	
	@Override
	public Optional<BidListDTO> read(Integer id)
	{
		Optional<BidList> bidListRead = bidListRepository.findById(id);
		BidList bidList = bidListRead.get();
		
		BidListDTO bidListDTO = new BidListDTO(
				bidList.getBidListId(),
				bidList.getAccount(), 
				bidList.getType(), 
				bidList.getBidQuantity());
				
		
		return Optional.of(bidListDTO);
	}
	
	@Override
	public List<BidListDTO> readAll()
	{
		List<BidList>  list = bidListRepository.findAll();
		List<BidListDTO>  listDTO = new ArrayList<>();
		
		for (BidList bidlist : list)
		{
			listDTO.add( new BidListDTO(
					bidlist.getBidListId(),
					bidlist.getAccount(), 
					bidlist.getType(), 
					bidlist.getBidQuantity()));
		}
		
		return listDTO;
	}

	
	
	@Override
	public void delete (Integer id)
	{
		bidListRepository.deleteById(id);
	}
	
	
	@Override
	public BidList update(Integer bidListID, BidListDTO blDTO)
	{
		BidList bidList = bidListRepository.findById(bidListID).get();
		
		bidList.setAccount(blDTO.getAccount());
		bidList.setType(blDTO.getType());
		bidList.setBidQuantity(blDTO.getBidQuantity());
		
		bidListRepository.save(bidList);
		
		return bidList;
	}
	
	

}
