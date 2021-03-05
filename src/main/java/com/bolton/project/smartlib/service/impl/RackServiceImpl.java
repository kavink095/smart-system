package com.bolton.project.smartlib.service.impl;

import com.bolton.project.smartlib.dto.RackDTO;
import com.bolton.project.smartlib.entity.Rack;
import com.bolton.project.smartlib.repository.RackRepository;
import com.bolton.project.smartlib.service.RackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RackServiceImpl implements RackService {

    @Autowired
    private RackRepository rackRepository;

    @Override
    public int addNewRack(RackDTO rackDTO) {
        int ret = 0;

        try {
            List<Rack> rackList = rackRepository.findByRacid(rackDTO.getRacid());

            if (!rackList.isEmpty()) {
                ret = 2;
            } else {
                Rack rack = new Rack();
                rack.setRacid(rackDTO.getRacid());
                rack.setRackdesc(rackDTO.getRackdesc());

                Object obj = rackRepository.save(rack);
                if (obj == null) {
                    ret = 0;
                } else {
                    ret = 1;
                }
            }
            return ret;

        } catch (Exception e) {
            e.printStackTrace();
            return ret;
        }
    }

    @Override
    public ArrayList<RackDTO> getAllRacks() {
        List<Rack> rackList = rackRepository.findAll();
        ArrayList<RackDTO> rackDTOs = new ArrayList<>();
        rackList.forEach(rack -> rackDTOs.add(new RackDTO(rack.getRacid(),rack.getRackdesc())));
        return rackDTOs;
    }
}
