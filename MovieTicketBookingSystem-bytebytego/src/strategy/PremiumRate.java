package strategy;

import java.math.BigDecimal;

public class PremiumRate implements PricingStrategy {
    private final BigDecimal price;

    public PremiumRate(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public SeatType getSeatType() {
        return SeatType.PREMIUM;
    }

}
