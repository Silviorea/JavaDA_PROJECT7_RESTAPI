package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.dto.BidListDTO;
import com.nnk.springboot.repositories.dto.CurvePointDTO;

public interface CurvePointService
{
	public CurvePoint create (CurvePointDTO curvePointDTO);
	public Optional<CurvePointDTO> read (Integer id);
	public List<CurvePointDTO> readAll();
	public CurvePoint update (Integer id, CurvePointDTO curvePointDTO);
	public void delete (Integer id);
}
