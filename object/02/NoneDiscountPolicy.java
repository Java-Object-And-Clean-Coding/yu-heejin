public class NoneDiscountPolicy implements DiscountPolicy {
    // @Override
    // protected Money getDiscountAmount(Screening screening) {
    //     return Money.ZERO;
    // }

    @Override
    protected Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}

// 일관성을 지키기 위해 0원이라는 할인 요금을 계산할 책임을 그대로
// DiscountPolicy 계층에 유지시키는 것이다.

// getDiscountAmount() 메서드는 어떤 값을 반환하더라도 상관없다..?
// DiscountPolicy에서 할인 조건이 없을 경우에는 해당 메서드를 호출하지 않기 때문이다.
// 이는 부모 클래스인 DiscountPolicy와 NoneDiscountPolicy를 개념적으로 결합시킨다.
// NoneDiscountPolicy의 개발자는 getDiscountAmount()가 호출되지 않을 경우
// DiscountPolicy가 0원을 반환할 것이라는 사실을 가정하고 있기 때문이다.
// 이와 같은 문제를 해결하는 법은 DiscountPolicy를 인터페이스로 바꾸고, NoneDiscountPolicy가
// DiscountPolicy의 getDiscountAmount() 메서드가 아닌 calculateDiscountAmount() 연산을
// 오버라이딩 하도록 변경하는 것이다. (즉, NoneDiscount와 DiscountPolicy를 같은 계층으로 만든다.)