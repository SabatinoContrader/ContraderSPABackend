package it.contrader.sprint4.converter;

import it.contrader.sprint4.dto.GommaDTO;
import it.contrader.sprint4.model.GommaEntity;
import org.springframework.stereotype.Component;

@Component
public class GommaConverter implements Converter<GommaEntity, GommaDTO> {


    public GommaDTO convertToDTO (GommaEntity gommaEntity) {
        return new GommaDTO(gommaEntity.getModel(), gommaEntity.getManufacturer(), gommaEntity.getPrice(), gommaEntity.getWidth(), gommaEntity.getHeight(),
                gommaEntity.getDiameter(), gommaEntity.getWeight(), gommaEntity.getSpeed(), gommaEntity.getSeason(), gommaEntity.getTypeVehicle(), (int) gommaEntity.getQuantity());
    }

    /* width, height, diameter, weight, speed, season, typeVehicle, quantity */

    public GommaEntity convertToEntity (GommaDTO gommaDTO) {
        GommaEntity gommaEntity = new GommaEntity();
        gommaEntity.setModel(gommaDTO.getModel());
        gommaEntity.setManufacturer(gommaDTO.getManufacturer());
        gommaEntity.setPrice(gommaDTO.getPrice());
        gommaEntity.setWidth(gommaDTO.getWidth());
        gommaEntity.setHeight(gommaDTO.getHeight());
        gommaEntity.setDiameter(gommaDTO.getDiameter());
        gommaEntity.setWeight(gommaDTO.getWeight());
        gommaEntity.setSpeed(gommaDTO.getSpeed());
        gommaEntity.setSeason(gommaDTO.getSeason());
        gommaEntity.setTypeVehicle(gommaDTO.getTypeVehicle());
        gommaEntity.setQuantity(gommaDTO.getQuantity());
        return gommaEntity;
    }
}
