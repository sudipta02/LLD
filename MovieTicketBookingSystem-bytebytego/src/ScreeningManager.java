import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScreeningManager {
    private final Map<Movie, List<Screening>> screeningsByMovie;
    private final Map<Screening, List<Ticket>> ticketsByScreening;

    public ScreeningManager() {
        this.screeningsByMovie = new HashMap<>();
        this.ticketsByScreening = new HashMap<>();
    }

    public void addScreening(Movie movie, Screening screening) {
        screeningsByMovie.computeIfAbsent(movie, k -> new ArrayList<>()).add(screening);
    }

    public List<Screening> getScreeningsForMovie(Movie movie) {
        return screeningsByMovie.getOrDefault(movie, new ArrayList<>());
    }

    public void addTicket(Screening screening, Ticket ticket) {
        ticketsByScreening.computeIfAbsent(screening, k -> new ArrayList<>()).add(ticket);
    }

    public List<Ticket> getTicketsForScreening(Screening screening) {
        return ticketsByScreening.getOrDefault(screening, new ArrayList<>());
    }

    public List<Seat> getAvailableSeats(Screening screening) {
        List<Seat> allSeats = screening.getRoom().getLayout().getAllSeats();
        List<Ticket> bookedTickets = getTicketsForScreening(screening);

        List<Seat> availableSeats = new ArrayList<>(allSeats);
        for (Ticket ticket : bookedTickets) {
            availableSeats.remove(ticket.getSeat());
        }

        return availableSeats;
    }
}
