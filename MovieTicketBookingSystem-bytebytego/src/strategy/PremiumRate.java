package strategy;

import java.math.BigDecimal;

public class PremiumRate implements PricingStrategy {
    private final BigDecimal price;

    public PremiumRate() {
        this.price = BigDecimal.valueOf(200.00);
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
