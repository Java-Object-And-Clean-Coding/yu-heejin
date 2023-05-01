// AmountDiscountPolicy는 금액 할인 정책으로, DiscountPolicy의 자식 클래스
// 할인 조건을 만족할 경우 일정한 금액을 할인해주는 금액 할인 정책
public class AmountDiscountPolicy extends DiscountPolicy {
    private Money discountAmount;  // 할인 요금을 저장한다.

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition ... conditions) {
        super(conditions);  // 부모 클래스의 conditions 저장
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}