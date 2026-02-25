import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import strategy.SeatType;

public class Room {
    private final String roomNumber;
    private final int rows;
    private final int columns;
    private final List<Seat> allSeats;
    private final Map<Integer, Map<Integer, Seat>> seatsByPosition;

    public Room(String roomNumber, int rows, int columns) {
        this.roomNumber = roomNumber;
        this.rows = rows;
        this.columns = columns;
        this.allSeats = new ArrayList<>();
        this.seatsByPosition = new HashMap<>();
        initializeSeats();
    }

    public void initializeSeats() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                addSeat(i, j);
            }
        }
    }

    public void addSeat(int row, int column) {
        String seatNumber = row + "-" + column;
        SeatType seatType = determineSeatType(row);
        Seat seat = new Seat(seatNumber, seatType);
        allSeats.add(seat);
        seatsByPosition.computeIfAbsent(row, k -> new HashMap<>()).put(column, seat);
    }

    private SeatType determineSeatType(int row) {
        if (row <= 1) {
            return SeatType.VIP;
        } else if (row <= 3) {
            return SeatType.PREMIUM;
        } else {
            return SeatType.NORMAL;
        }
    }

    public Seat getSeatByPosition(int row, int column) {
        Map<Integer, Seat> rowSeats = seatsByPosition.get(row);
        return (rowSeats != null) ? rowSeats.get(column) : null;
    }

    public List<Seat> getAllSeats() {
        return List.copyOf(allSeats);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

}
