import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import strategy.PricingStrategy;

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

        System.out.println("Added movies:");
        System.out.println("  1. " + movie1.getTitle() + " (" + movie1.getGenre() + ", " + movie1.getDurationInMinutes()
                + " min)");
        System.out.println("  2. " + movie2.getTitle() + " (" + movie2.getGenre() + ", " + movie2.getDurationInMinutes()
                + " min)");
        System.out.println("  3. " + movie3.getTitle() + " (" + movie3.getGenre() + ", " + movie3.getDurationInMinutes()
                + " min)");
        System.out.println();

        // ===========================================
        // STEP 2: Create Cinema with Rooms and Seats
        // ===========================================
        System.out.println("--- Setting up Cinema ---");

        // Create pricing strategies
        PricingStrategy normalRate = new strategy.NormalRate(new BigDecimal("12.00"));
        PricingStrategy premiumRate = new strategy.PremiumRate(new BigDecimal("18.00"));
        PricingStrategy vipRate = new strategy.VIPRate(new BigDecimal("25.00"));

        // Create cinema
        Cinema cinema = new Cinema("Grand Cinema", "Downtown");
        bookingSystem.addCinema(cinema);

        // Create layout for Room 1 (5 rows x 8 columns)
        Layout layout1 = new Layout(5, 8);

        // Set pricing strategies for seats (rows 0-1: VIP, rows 2-3: Premium, row 4:
        // Normal)
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                Seat seat = layout1.getSeatByPosition(i, j);
                if (i < 2) {
                    seat.setPricingStrategy(vipRate);
                } else if (i < 4) {
                    seat.setPricingStrategy(premiumRate);
                } else {
                    seat.setPricingStrategy(normalRate);
                }
            }
        }

        Room room1 = new Room("Room 1", layout1);
        cinema.addRoom(room1);

        // Create layout for Room 2
        Layout layout2 = new Layout(4, 6);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                Seat seat = layout2.getSeatByPosition(i, j);
                if (i < 1) {
                    seat.setPricingStrategy(vipRate);
                } else if (i < 2) {
                    seat.setPricingStrategy(premiumRate);
                } else {
                    seat.setPricingStrategy(normalRate);
                }
            }
        }

        Room room2 = new Room("Room 2", layout2);
        cinema.addRoom(room2);

        System.out.println("Created cinema: " + cinema.getName() + " at " + cinema.getLocation());
        System.out.println("  - " + room1.getRoomNumber() + ": " + layout1.getAllSeats().size() + " seats");
        System.out.println("  - " + room2.getRoomNumber() + ": " + layout2.getAllSeats().size() + " seats");
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

        // Show a few available seats
        System.out.print("Sample available seats: ");
        int count = 0;
        for (Seat seat : availableSeats) {
            if (count >= 10) {
                System.out.print("...");
                break;
            }
            System.out.print(seat.getSeatNumber() + "(" + seat.getPricingStrategy().getPrice() + ") ");
            count++;
        }
        System.out.println("\n");

        // ===========================================
        // STEP 5: Book Tickets
        // ===========================================
        System.out.println("--- Booking Tickets ---");

        // Book VIP seats (row 0-1)
        Seat seat1 = layout1.getSeatByPosition(0, 0); // VIP
        Seat seat2 = layout1.getSeatByPosition(0, 1); // VIP

        // Book Premium seat (row 2)
        Seat seat3 = layout1.getSeatByPosition(2, 3); // Premium

        // Book Normal seat (row 4)
        Seat seat4 = layout1.getSeatByPosition(4, 4); // Normal

        System.out.println("Selecting seats:");
        System.out.println("  - Seat " + seat1.getSeatNumber() + " (VIP): $" + seat1.getPricingStrategy().getPrice());
        System.out.println("  - Seat " + seat2.getSeatNumber() + " (VIP): $" + seat2.getPricingStrategy().getPrice());
        System.out
                .println("  - Seat " + seat3.getSeatNumber() + " (Premium): $" + seat3.getPricingStrategy().getPrice());
        System.out
                .println("  - Seat " + seat4.getSeatNumber() + " (Normal): $" + seat4.getPricingStrategy().getPrice());

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
            String seatType = "Normal";
            if (ticket.getSeat().getPricingStrategy() instanceof strategy.VIPRate) {
                seatType = "VIP";
            } else if (ticket.getSeat().getPricingStrategy() instanceof strategy.PremiumRate) {
                seatType = "Premium";
            }
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
        System.out.println("Seats remaining: " + availableSeats.size() + " out of " + layout1.getAllSeats().size());

        System.out.println("\n===========================================");
        System.out.println("   DEMO COMPLETED SUCCESSFULLY!");
        System.out.println("===========================================");
    }
}
