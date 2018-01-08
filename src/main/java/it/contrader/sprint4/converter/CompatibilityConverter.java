package it.contrader.sprint4.converter;

import it.contrader.sprint4.dto.CompatibilityDTO;
import it.contrader.sprint4.model.CompatibilityEntity;

public class CompatibilityConverter implements Converter<CompatibilityEntity, CompatibilityDTO> {

    public CompatibilityDTO convertToDTO(CompatibilityEntity compatibilityEntity){
        return new CompatibilityDTO(compatibilityEntity.getId_vehicle(), compatibilityEntity.getId_gomme());
    }

    public CompatibilityEntity convertToEntity(CompatibilityDTO compatibilityDTO){
        CompatibilityEntity compatibilityEntity = new CompatibilityEntity();
        compatibilityEntity.setId_vehicle(compatibilityDTO.getId_vehicle());
        compatibilityEntity.setId_gomme(compatibilityDTO.getId_gomme());
        return compatibilityEntity;
    }

}
