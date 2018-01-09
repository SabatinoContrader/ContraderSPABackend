package it.contrader.sprint4.controller;

import it.contrader.sprint4.GenericResponse;
import it.contrader.sprint4.converter.GommaConverter;
import it.contrader.sprint4.converter.VehicleConverter;
import it.contrader.sprint4.dto.GommaDTO;
import it.contrader.sprint4.dto.VehicleDTO;
import it.contrader.sprint4.model.GommaEntity;
import it.contrader.sprint4.model.VehicleEntity;
import it.contrader.sprint4.service.CompatibilityService;
import it.contrader.sprint4.service.GommaService;
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
    private CompatibilityService compatibilityService;
    private GommaService gommaService;
    private GommaConverter gommaConverter;

    @Autowired
    public VehicleController(VehicleService vehicleService, VehicleConverter vehicleConverter, CompatibilityService compatibilityService, GommaService gommaService, GommaConverter gommaConverter){
        this.vehicleService=vehicleService;
        this.vehicleConverter=vehicleConverter;
        this.compatibilityService=compatibilityService;
        this.gommaService=gommaService;
        this.gommaConverter=gommaConverter;
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

    @RequestMapping(value="/searchVehicle", method = RequestMethod.POST)
    public GenericResponse<List<GommaDTO>> searchVehicles(@RequestBody VehicleDTO vehicleDTO){
        VehicleEntity vehicleFind=vehicleConverter.convertToEntity(vehicleDTO);
        VehicleEntity myVehicle=vehicleService.findByBrandAndModelAndFuelAndVersionAndCapacity(vehicleFind);
        if(myVehicle!=null) {

            int id_vehicle=(int)myVehicle.getIdVehicle();
            List<Integer> listIdGomme = compatibilityService.getAllIdGommeForIdVehicle(id_vehicle);
            if(listIdGomme.size()!=0) {
                List<GommaEntity> listgommeEntity = new ArrayList<>();
                for (Integer idGomma : listIdGomme) {
                    listgommeEntity.add(gommaService.findById(idGomma));
                }

                List<GommaDTO> gommeVehicle = new ArrayList<>();
                for (GommaEntity g : listgommeEntity) {
                    gommeVehicle.add(gommaConverter.convertToDTO(g));
                }

                return new GenericResponse<>(0, gommeVehicle);
            }
            else return new GenericResponse<>(2,null);
        }
            else
                return new GenericResponse<>(1, null);


    }





}
