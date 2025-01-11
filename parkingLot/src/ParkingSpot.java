import VehicleType.Vehicle;
import VehicleType.VehicleType;

public class ParkingSpot {
    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber, VehicleType vehicleType){
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }

    public boolean isAvailable(){
        return parkedVehicle == null;
    }

    public void parkVehicle(Vehicle vehicle){
        if(isAvailable() && vehicle.getType() == vehicleType){
            parkedVehicle = vehicle;
        }
    }

    public void unparkVehicle(){
        parkedVehicle = null;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
