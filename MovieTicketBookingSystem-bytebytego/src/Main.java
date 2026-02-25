import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import strategy.SeatType;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("===========================================");
        System.out.println("   MOVIE TICKET BOOKING SYSTEM DEMO");
        System.out.println("===========================================\n");

        // Create the booking system
        MoviewBookingSytem bookingSystem = new MoviewBookingSytem();

        // ===========================================
        // STEP 1: Create Movies
        // ===========================================
        System.out.println("--- Creating Movies ---");

        Movie movie1 = new Movie("The Matrix", "Action", 136);
        Movie movie2 = new Movie("Inception", "Sci-Fi", 148);
        Movie movie3 = new Movie("The Avengers", "Superhero", 143);

        bookingSystem.addMovie(movie1);
        bookingSystem.addMovie(movie2);
        bookingSystem.addMovie(movie3);

        // ===========================================
        // STEP 2: Create Cinema with Rooms and Seats
        // ===========================================
        // Create cinema
        Cinema cinema = new Cinema("Grand Cinema", "Downtown");
        bookingSystem.addCinema(cinema);

        // Create Room 1 (5 rows x 8 columns)
        Room room1 = new Room("Room 1", 5, 8);
        cinema.addRoom(room1);

        // Create Room 2 (4 rows x 6 columns)
        Room room2 = new Room("Room 2", 4, 6);
        cinema.addRoom(room2);

        System.out.println("Created cinema: " + cinema.getName() + " at " + cinema.getLocation());
        System.out.println("  - " + room1.getRoomNumber() + ": " + room1.getAllSeats().size() + " seats");
        System.out.println("  - " + room2.getRoomNumber() + ": " + room2.getAllSeats().size() + " seats");
        System.out.println();

        // ===========================================
        // STEP 3: Schedule Screenings
        // ===========================================
        System.out.println("--- Scheduling Screenings ---");

        LocalDateTime now = LocalDateTime.now();

        // Screening 1: The Matrix in Room 1 at 2:00 PM
        Screening screening1 = new Screening(movie1, room1,
                now.plusDays(1).withHour(14).withMinute(0),
                now.plusDays(1).withHour(16).withMinute(16));
        bookingSystem.addScreening(movie1, screening1);

        // Screening 2: Inception in Room 2 at 6:00 PM
        Screening screening2 = new Screening(movie2, room2,
                now.plusDays(1).withHour(18).withMinute(0),
                now.plusDays(1).withHour(20).withMinute(28));
        bookingSystem.addScreening(movie2, screening2);

        // Screening 3: The Avengers in Room 1 at 8:00 PM
        Screening screening3 = new Screening(movie3, room1,
                now.plusDays(1).withHour(20).withMinute(0),
                now.plusDays(1).withHour(22).withMinute(23));
        bookingSystem.addScreening(movie3, screening3);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm a");

        System.out.println("Screenings scheduled:");
        System.out.println("  1. " + movie1.getTitle() + " - " + room1.getRoomNumber() + " @ "
                + screening1.getStartTime().format(formatter));
        System.out.println("  2. " + movie2.getTitle() + " - " + room2.getRoomNumber() + " @ "
                + screening2.getStartTime().format(formatter));
        System.out.println("  3. " + movie3.getTitle() + " - " + room1.getRoomNumber() + " @ "
                + screening3.getStartTime().format(formatter));
        System.out.println();

        // ===========================================
        // STEP 4: Display Available Seats
        // ===========================================
        System.out.println("--- Available Seats for 'The Matrix' ---");

        List<Seat> availableSeats = bookingSystem.getScreeningManager().getAvailableSeats(screening1);
        System.out.println("Total available seats: " + availableSeats.size());

        // ===========================================
        // STEP 5: Book Tickets
        // ===========================================
        System.out.println("--- Booking Tickets ---");

        // Book VIP seats (row 0-1)
        Seat seat1 = room1.getSeatByPosition(0, 0); // VIP
        Seat seat2 = room1.getSeatByPosition(0, 1); // VIP

        // Book Premium seat (row 2)
        Seat seat3 = room1.getSeatByPosition(2, 3); // Premium

        // Book Normal seat (row 4)
        Seat seat4 = room1.getSeatByPosition(4, 4); // Normal

        // Book the tickets
        bookingSystem.bookTicket(screening1, seat1);
        bookingSystem.bookTicket(screening1, seat2);
        bookingSystem.bookTicket(screening1, seat3);
        bookingSystem.bookTicket(screening1, seat4);

        System.out.println("\nTickets booked successfully!");
        System.out.println();

        // ===========================================
        // STEP 6: Create Order and Calculate Total
        // ===========================================
        System.out.println("--- Order Summary ---");

        // Get all booked tickets for this screening
        List<Ticket> tickets = bookingSystem.getScreeningManager().getTicketsForScreening(screening1);

        BigDecimal total = BigDecimal.ZERO;
        System.out.println("Movie: " + movie1.getTitle());
        System.out.println("Screening: " + screening1.getStartTime().format(formatter));
        System.out.println("\nTickets purchased:");

        for (Ticket ticket : tickets) {
            SeatType seatType = ticket.getSeat().getSeatType();
            System.out.println(
                    "  - Seat " + ticket.getSeat().getSeatNumber() + " (" + seatType + "): $" + ticket.getPrice());
            total = total.add(ticket.getPrice());
        }

        System.out.println("\n-----------------------------------");
        System.out.println("TOTAL: $" + total);
        System.out.println("-----------------------------------");
        System.out.println();

        // ===========================================
        // STEP 7: Show Remaining Available Seats
        // ===========================================
        System.out.println("--- Remaining Available Seats ---");

        availableSeats = bookingSystem.getScreeningManager().getAvailableSeats(screening1);
        System.out.println("Seats remaining: " + availableSeats.size() + " out of " + room1.getAllSeats().size());
    }
}
