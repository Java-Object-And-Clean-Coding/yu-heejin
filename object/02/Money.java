// 금액과 관련된 다양한 계산을 구현한 클래스
public class Money {
    public static final Money ZERO = Money.wons(0);
    private final BigDecimal AMOUNT;   
    // Q. 상수로 선언한 이유는 무엇인가? 상수도 나중에 값을 변경할 수 있는가?
    // Q. BigDecimal 타입? - 소수점을 정밀하게 다룰 수 있는 타입

    Money(BigDecimal amount) {
        this.AMOUNT = amount;
    }

    public static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public static Money wons(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public Money plus(Money amount) {
        return new Money(this.AMOUNT.add(amount.AMOUNT));
    }

    public Money minus(Money amount) {
        return new Money(this.AMOUNT.substract(amount.AMOUNT));
    }

    public Money times(double percent) {
        return new Money(this.AMOUNT.multiply(BigDecimal.valueOf(percent)));
    }

    public boolean isLessThan(Money other) {
        return AMOUNT.compareTo(other.AMOUNT) < 0;
    }

    public boolean isGreaterThanOrEqual(Money other) {
        return AMOUNT.compareTo(other.AMOUNT) >= 0;
    }
}