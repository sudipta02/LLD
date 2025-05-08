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

        Vehicle car2 = new Car("OD-33-1112");
        Vehicle bike2 = new Bike("OD-33-2223");

        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(bike);

        parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(bike2);

        parkingLot.displayAvailability();

        parkingLot.unparkVehicle(bike);

        parkingLot.displayAvailability();
    }

}
