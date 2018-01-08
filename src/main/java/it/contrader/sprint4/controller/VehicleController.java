package it.contrader.sprint4.controller;

import it.contrader.sprint4.GenericResponse;
import it.contrader.sprint4.converter.VehicleConverter;
import it.contrader.sprint4.dto.VehicleDTO;
import it.contrader.sprint4.model.VehicleEntity;
import it.contrader.sprint4.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(value="*")
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private VehicleService vehicleService;
    private VehicleConverter vehicleConverter;
    @Autowired
    public VehicleController(VehicleService vehicleService, VehicleConverter vehicleConverter){
        this.vehicleService=vehicleService;
        this.vehicleConverter=vehicleConverter;
    }

    @RequestMapping(value="/allvehicles", method = RequestMethod.GET)
    public GenericResponse<List<VehicleDTO>> getAllVehicles ()
    {
        List<VehicleDTO> vehicles = new ArrayList<>();
        for(VehicleEntity vehicleEntity: vehicleService.getAllVehicles()){
            vehicles.add(vehicleConverter.convertToDTO(vehicleEntity));
        }

        return new GenericResponse<>(0, vehicles);
    }

    @RequestMapping(value="/insertVehicle", method = RequestMethod.POST)
    public GenericResponse<VehicleDTO> getinsertVehicles(@RequestBody VehicleDTO vehicleDTO)
    {
        VehicleEntity vehicleInsert=vehicleService.insert(vehicleConverter.convertToEntity(vehicleDTO));
        if (vehicleInsert != null) {
            return new GenericResponse<>(0, vehicleDTO);
        }
        else return new GenericResponse<>(1, null);
    }





}
