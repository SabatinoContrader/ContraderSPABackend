package it.contrader.sprint4.converter;

import it.contrader.sprint4.dto.VehicleDTO;
import it.contrader.sprint4.model.VehicleEntity;
import org.springframework.stereotype.Component;

@Component
public class VehicleConverter implements Converter<VehicleEntity, VehicleDTO> {


    public VehicleEntity convertToEntity(VehicleDTO vehicleDTO) {
        VehicleEntity vehicleEntity=new VehicleEntity();
        vehicleEntity.setBrand(vehicleDTO.getBrand());
        vehicleEntity.setModel(vehicleDTO.getModel());
        vehicleEntity.setFuel(vehicleDTO.getFuel());
        vehicleEntity.setVersion(vehicleDTO.getVersion());
        vehicleEntity.setCapacity(vehicleDTO.getCapacity());
        return vehicleEntity;
    }


    public VehicleDTO convertToDTO(VehicleEntity vehicleEntity) {
        return new VehicleDTO(vehicleEntity.getBrand(),vehicleEntity.getModel(),vehicleEntity.getFuel(),vehicleEntity.getVersion(),vehicleEntity.getCapacity());
    }
}
