package com.bolton.project.smartlib.service;

import com.bolton.project.smartlib.dto.RackDTO;

import java.util.ArrayList;

public interface RackService {
    public int addNewRack(RackDTO rackDTO);
    public ArrayList<RackDTO> getAllRacks();
}
