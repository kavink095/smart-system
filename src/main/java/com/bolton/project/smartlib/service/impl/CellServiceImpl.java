package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.dto.CellDTO;
import com.bolton.project.smartlib.entity.Cell;
import com.bolton.project.smartlib.repository.CellRepository;
import com.bolton.project.smartlib.repository.RackRepository;
import com.bolton.project.smartlib.service.CellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CellServiceImpl implements CellService {

    @Autowired
    private CellRepository cellRepository;

    @Autowired
    private RackRepository rackRepository;

    @Override
    public boolean addNewCell(CellDTO cellDTO) {
        Cell cell = new Cell();
        cell.setCelid(cellDTO.getCelid());
        cell.setCelldesc(cellDTO.getCelldesc());
        cell.setRack(rackRepository.getOne(cellDTO.getRackDTO().getRackid()));

        cellRepository.save(cell);
        return true;
    }
}
