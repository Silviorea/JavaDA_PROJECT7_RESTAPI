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

/**
 * Implementation of CurvePoint Service Interface.
 * All of the CRUD methods are defined here
 * @author Silvio
 *
 */

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
		
		curvePointRepo.save(newCurvePoint);
		
		return newCurvePoint;
	}

	
	@Override
	public Optional<CurvePointDTO> read(Integer id)
	{
		CurvePoint curvePoint = curvePointRepo.findById(id).get();
		
		CurvePointDTO curvePointDTO = new CurvePointDTO(
				curvePoint.getId(),
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
					curveList.getId(),
					curveList.getCurveId(),
					curveList.getTerm(),
					curveList.getValue()));
		}
		
		return listDTO;
	}

	@Override
	public CurvePoint update(Integer id, CurvePointDTO curvePointDTO)
	{
		CurvePoint curvePoint = curvePointRepo.findById(id).get();
		
		curvePoint.setCurveId(curvePointDTO.getCurveId());
		curvePoint.setTerm(curvePointDTO.getTerm());
		curvePoint.setValue(curvePointDTO.getValue());
		
		curvePointRepo.save(curvePoint);
		
		return curvePoint;
	}

	@Override
	public void delete(Integer id)
	{
		curvePointRepo.deleteById(id);
		
	}
}
