public class Movie {
    private String title;  // 영화 제목
    private Duration runningTime;  // 상영 시간
    private Money fee;  // 기본 요금
    private DiscountPolicy discountPolicy;  // 할인 정책

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    // discountPolicy에 calculateDiscountAmount 메시지를 전송해 할인 요금을 반환받는다.
    // Movie는 기본 요금인 fee에서 반환된 할인 요금을 차감한다.
    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}