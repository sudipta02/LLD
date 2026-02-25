package strategy;

import java.math.BigDecimal;

public class NormalRate implements PricingStrategy {
    private final BigDecimal price;

    public NormalRate() {
        this.price = BigDecimal.valueOf(100.00);
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public SeatType getSeatType() {
        return SeatType.NORMAL;
    }

}