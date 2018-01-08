package it.contrader.sprint4.controller;

import it.contrader.sprint4.GenericResponse;
import it.contrader.sprint4.converter.GommaConverter;
import it.contrader.sprint4.dto.GommaDTO;
import it.contrader.sprint4.model.GommaEntity;
import it.contrader.sprint4.service.GommaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(value="*")
@RestController
@RequestMapping("/gomme")
public class GommaController
{

    private GommaService gommaService;
    private GommaConverter gommaConverter;

    @Autowired
    public GommaController (GommaService gommaService, GommaConverter gommaConverter)
    {
        this.gommaService = gommaService;
        this.gommaConverter = gommaConverter;
    }

    @RequestMapping(value="/allgomme",method = RequestMethod.GET)
    public GenericResponse<List<GommaDTO>> getAllGomme()
    {
        List<GommaDTO> gomme = new ArrayList<>();
        for (GommaEntity gommaEntity: gommaService.getAllGomme()) {
            gomme.add(gommaConverter.convertToDTO(gommaEntity));
        }
        return new GenericResponse<>(0, gomme);
    }

    @RequestMapping(value="/insertGomme", method = RequestMethod.POST)
    public GenericResponse<GommaDTO> insert (@RequestBody GommaDTO gommaDTO)
    {
         GommaEntity gommaInserita = gommaService.insertGomma(gommaConverter.convertToEntity(gommaDTO));
         if (gommaInserita != null) {
             return new GenericResponse<>(0, gommaDTO);
         }
         else return new GenericResponse<>(1, null);
    }

    @RequestMapping(value="/allgommeManufacturer", method = RequestMethod.GET)
    public GenericResponse<List<GommaDTO>> findByManufacturer (@RequestParam("manufacturer") String manufacturer, @RequestParam("typeVehicle") String typeVehicle)
    {
        List<GommaDTO> gomme = new ArrayList<>();
        for (GommaEntity gommaEntity: gommaService.findByManufacturer(manufacturer, typeVehicle)) {
            gomme.add(gommaConverter.convertToDTO(gommaEntity));
    }
        return new GenericResponse<>(0, gomme);
    }

  /*  @RequestMapping(value="/manufacturerForVehicle", method = RequestMethod.GET)
    public GenericResponse<String>*/


}