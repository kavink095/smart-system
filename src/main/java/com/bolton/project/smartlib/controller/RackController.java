package com.bolton.project.smartlib.controller;

import com.bolton.project.smartlib.dto.RackDTO;
import com.bolton.project.smartlib.dto.UserDTO;
import com.bolton.project.smartlib.service.RackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("api/v1/racks")
public class RackController {


    @Autowired
    private RackService rackService;

    @PostMapping("/create")
    public int saveUser(@RequestBody RackDTO rackDTO) {
        int valUser = rackService.addNewRack(rackDTO);
        switch (valUser) {
            case 0:
                valUser = 0;
                break;
            case 1:
                valUser = 1;
                break;
            case 2:
                valUser = 2;
        }
        return valUser;
    }
    @GetMapping("/getAll")
    public ArrayList<RackDTO> getAllRacks() {
        return rackService.getAllRacks();
    }

}
