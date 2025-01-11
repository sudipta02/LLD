package VehicleType;

public abstract class Vehicle {
    public String licensePlate;
    public VehicleType type;

    public Vehicle(String licensePlate, VehicleType type){
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }
}
