import VehicleType.Bike;
import VehicleType.Car;
import VehicleType.Vehicle;

public class ParkingLotDemo {
    public static void main(String[] args) throws Exception {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1, 10));
        parkingLot.addLevel(new Level(2, 20));

        Vehicle car = new Car("OD-33-1111");
        Vehicle bike = new Bike("OD-33-2222");

        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(bike);

        parkingLot.displayAvailability();

        parkingLot.unparkVehicle(bike);

        parkingLot.displayAvailability();
    }
    
}
