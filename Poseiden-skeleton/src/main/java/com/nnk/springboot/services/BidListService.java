package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.dto.BidListDTO;

public interface BidListService
{
	public BidList create (BidListDTO bidListDTO);
	public Optional<BidListDTO> read (Integer id);
	
	
	public BidList update(Integer bidListID, BidListDTO blDTO);
	
	
	public void delete (Integer id);
	
	public List<BidListDTO> readAll();
}
