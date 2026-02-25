package strategy;

import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal getPrice();
    SeatType getSeatType();
}
