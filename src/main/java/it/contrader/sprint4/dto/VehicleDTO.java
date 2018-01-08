package it.contrader.sprint4.dto;

public class VehicleDTO {

    private String brand ;

    private String model ;

    private String fuel ;

    private String version ;

    private String capacity ;

    public VehicleDTO(){}

    public VehicleDTO(String brand,String model,String fuel,String version,String capacity){
        this.brand=brand;
        this.model=model;
        this.fuel=fuel;
        this.version=version;
        this.capacity=capacity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}
