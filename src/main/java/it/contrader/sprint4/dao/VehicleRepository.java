package it.contrader.sprint4.dao;


import it.contrader.sprint4.model.VehicleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface VehicleRepository extends CrudRepository<VehicleEntity, Long> {

    List<VehicleEntity> findAll();
    List<VehicleEntity> findByBrand(String brand);

    VehicleEntity findByBrandAndModelAndFuelAndVersionAndCapacity(String brand, String model, String fuel, String version, String capacity);
}
