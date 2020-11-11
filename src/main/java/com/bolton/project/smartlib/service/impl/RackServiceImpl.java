package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.dto.RackDTO;
import com.bolton.project.smartlib.entity.Rack;
import com.bolton.project.smartlib.repository.LibraryRepository;
import com.bolton.project.smartlib.repository.RackRepository;
import com.bolton.project.smartlib.service.RackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RackServiceImpl implements RackService {

    @Autowired
    private RackRepository rackRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    public boolean addNewRack(RackDTO rackDTO) {
        Rack rack = new Rack();
        rack.setRackid(rackDTO.getRackid());
        rack.setRackdesc(rackDTO.getRackdesc());
        rack.setLibrary(libraryRepository.getOne(rackDTO.getLibraryDTO().getLibid()));

        rackRepository.save(rack);
        return true;
    }
}
