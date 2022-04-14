package com.nnk.springboot.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.repositories.dto.CurvePointDTO;
import com.nnk.springboot.services.CurvePointService;

@Service
public class CurvePointServiceImpl implements CurvePointService
{
	@Autowired
	CurvePointRepository curvePointRepo;
	

	@Override
	public CurvePoint create(CurvePointDTO curvePointDTO)
	{
		CurvePoint newCurvePoint = new CurvePoint(
				curvePointDTO.getCurveId(),
				curvePointDTO.getTerm(),
				curvePointDTO.getValue());
		
		return newCurvePoint;
	}

	
	@Override
	public Optional<CurvePointDTO> read(Integer id)
	{
		CurvePoint curvePoint = curvePointRepo.findById(id).get();
		
		CurvePointDTO curvePointDTO = new CurvePointDTO(
				curvePoint.getCurveId(),
				curvePoint.getTerm(),
				curvePoint.getValue());
		
		return Optional.of(curvePointDTO);
	}

	
	@Override
	public List<CurvePointDTO> readAll()
	{

		List<CurvePoint>  list = curvePointRepo.findAll();
		List<CurvePointDTO>  listDTO = new ArrayList<>();
		
		for (CurvePoint curveList : list)
		{
			listDTO.add( new CurvePointDTO(
					curveList.getCurveId(),
					curveList.getTerm(),
					curveList.getValue()));
		}
		
		return listDTO;
	}

	@Override
	public CurvePoint update(Integer id, Integer curveId, Double term, Double value)
	{
		CurvePoint curvePoint = curvePointRepo.findById(id).get();
		curvePoint.setCurveId(curveId);
		curvePoint.setTerm(term);
		curvePoint.setValue(value);
		
		curvePointRepo.save(curvePoint);
		
		return curvePoint;
	}

	@Override
	public void delete(Integer id)
	{
		curvePointRepo.deleteById(id);
		
	}
}
