package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.dto.TradeDTO;

public interface TradeService
{
	public Trade create (TradeDTO tradeDTO);
	public Optional<TradeDTO> read (Integer id);
	public List<TradeDTO> readAll ();
	public Trade update(Integer id, TradeDTO tradeDTO);
	public void delete (Integer id);
	
}
