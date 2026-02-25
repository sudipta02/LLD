public class Movie {
    private final String title;
    private final String genre;
    private final int durationInMinutes;

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public Movie(String title, String genre, int durationInMinutes) {
        this.title = title;
        this.genre = genre;
        this.durationInMinutes = durationInMinutes;
    }
}
