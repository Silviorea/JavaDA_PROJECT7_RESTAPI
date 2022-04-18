package com.nnk.springboot.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.repositories.dto.TradeDTO;
import com.nnk.springboot.services.TradeService;

@Service
public class TradeServiceImpl implements TradeService
{
	@Autowired
	TradeRepository tradeRepo;
	
	

	@Override
	public Trade create(TradeDTO tradeDTO)
	{
		Trade newTrade = new Trade(
				tradeDTO.getAccount(),
				tradeDTO.getType(),
				tradeDTO.getBuyQuantity());
		
		tradeRepo.save(newTrade);
		
		return newTrade;
	}

	@Override
	public Optional<TradeDTO> read(Integer id)
	{
		Trade trade = tradeRepo.findById(id).get();
		
		TradeDTO tradeDTO = new TradeDTO(
				trade.getTradeId(),
				trade.getAccount(),
				trade.getType(),
				trade.getBuyQuantity());
		
		return Optional.of(tradeDTO);
	}

	@Override
	public List<TradeDTO> readAll()
	{
		List<Trade> list = tradeRepo.findAll();
		List<TradeDTO> tradeDTO = new ArrayList<>();
		
		for (Trade trade : list)
		{
			tradeDTO.add(new TradeDTO(
					trade.getTradeId(),
					trade.getAccount(),
					trade.getType(),
					trade.getBuyQuantity()));
		}
		
		
		
		return tradeDTO;
	}

	@Override
	public Trade update(Integer id, String account, String type, Double buyQuantity)
	{
		Trade trade = tradeRepo.findById(id).get();
		
		trade.setAccount(account);
		trade.setType(type);
		trade.setBuyQuantity(buyQuantity);
		
		tradeRepo.save(trade);
		
		return trade;
	}

	@Override
	public void delete(Integer id)
	{
		tradeRepo.deleteById(id);
		
	}
	
	
}
