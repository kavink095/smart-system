package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.dto.RackDTO;
import com.bolton.project.smartlib.entity.Rack;
import com.bolton.project.smartlib.repository.RackRepository;
import com.bolton.project.smartlib.service.CellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RackServiceImpl implements CellService {

    @Autowired
    private RackRepository cellRepository;

    @Override
    public boolean addNewCell(RackDTO rackDTO) {
        Rack rack = new Rack();
        rack.setRacid(rackDTO.getRacid());
        rack.setRackdesc(rackDTO.getRackdesc());

        cellRepository.save(rack);
        return true;
    }
}
