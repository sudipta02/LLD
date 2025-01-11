import java.util.ArrayList;
import java.util.List;

import VehicleType.Vehicle;
import VehicleType.VehicleType;

public class Level {
    private final int floor;
    private final List<ParkingSpot> parkingSpots;

    public Level(int floor, int numSpots) {
        this.floor = floor;
        parkingSpots = new ArrayList<>(numSpots);

        double bikeSpots = 0.3;

        int numBikes = (int) (numSpots * bikeSpots);
        
        for(int i = 1; i <= numBikes; i++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.BIKE));
        }
        for(int i = numBikes + 1; i <= numSpots; i++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
        }
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(ParkingSpot parkingSpot: parkingSpots){
            if(parkingSpot.isAvailable() && parkingSpot.getVehicleType() == vehicle.getType()) {
                parkingSpot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle){
        for(ParkingSpot parkingSpot: parkingSpots){
            if(!parkingSpot.isAvailable() && parkingSpot.getParkedVehicle().equals(vehicle)){
                parkingSpot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        System.out.println("Level " + floor + " availability:");
        for(ParkingSpot parkingSpot: parkingSpots){
            System.out.println("Spot " + parkingSpot.getSpotNumber() + ": " + (parkingSpot.isAvailable() ? "Available for" : "occupied by ") + " " + parkingSpot.getVehicleType());
        }
    }
}
