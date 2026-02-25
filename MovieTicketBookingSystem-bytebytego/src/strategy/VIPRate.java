package strategy;

import java.math.BigDecimal;

public class VIPRate implements PricingStrategy {
    private final BigDecimal price;

    public VIPRate() {
        this.price = BigDecimal.valueOf(300.00);
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public SeatType getSeatType() {
        return SeatType.VIP;
    }
}
