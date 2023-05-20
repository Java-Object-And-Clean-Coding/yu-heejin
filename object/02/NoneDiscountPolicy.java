public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}

// 일관성을 지키기 위해 0원이라는 할인 요금을 계산할 책임을 그대로
// DiscountPolicy 계층에 유지시키는 것이다.