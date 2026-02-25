import strategy.NormalRate;
import strategy.PremiumRate;
import strategy.PricingStrategy;
import strategy.SeatType;
import strategy.VIPRate;

public class Seat {
    private final String seatNumber;
    private final PricingStrategy pricingStrategy;
    private final SeatType seatType;

    public Seat(String seatNumber, SeatType seatType) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        if (seatType == SeatType.NORMAL) {
            this.pricingStrategy = new NormalRate();
        } else if (seatType == SeatType.PREMIUM) {
            this.pricingStrategy = new PremiumRate();
        } else if (seatType == SeatType.VIP) {
            this.pricingStrategy = new VIPRate();
        } else {
            this.pricingStrategy = new NormalRate();
        }
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public SeatType getSeatType() {
        return seatType;
    }

}
