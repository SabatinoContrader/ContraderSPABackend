package it.contrader.sprint4.dto;

public class CompatibilityDTO {

    private int id_vehicle;

    private int id_gomme;

    public CompatibilityDTO(){}

    public CompatibilityDTO(int id_vehicle, int id_gomme)
    {
        this.id_vehicle = id_vehicle;
        this.id_gomme = id_gomme;
    }

    public int getId_vehicle() {
        return id_vehicle;
    }

    public void setId_vehicle(int id_vehicle) {
        this.id_vehicle = id_vehicle;
    }

    public int getId_gomme() {
        return id_gomme;
    }

    public void setId_gomme(int id_gomme) {
        this.id_gomme = id_gomme;
    }

}
