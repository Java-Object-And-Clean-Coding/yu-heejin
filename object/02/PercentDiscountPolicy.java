// DiscountPolicy의 자식 클래스, getDiscountAmount 메서드를 오버라이딩한다.
// 고정 금액이 아닌 일정 비율을 차감하는 비율 할인 정책
public class PercentDiscountPolicy extends DiscountPolicy {
    private double percent;   // 할인 비율을 저장한다.

    public PercentDiscountPolicy(double percent, DiscountCondition ... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}