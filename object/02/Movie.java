public class Movie {
    private String title;  // 영화 제목
    private Duration runningTime;  // 상영 시간
    private Money fee;  // 기본 요금
    private DiscountPolicy discountPolicy;  // 할인 정책

    // 해당 속성들의 값은 생성자를 통해 전달받는다.
    // 오직 하나의 discountPolicy 인스턴스만을 받도록 선언되어 제약을 강제한다.
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
    // 해당 메서드에는 이상한 점이 존재하는데, 어떤 할인 정책을 사용할 것인지 결정하는 코드가 어디에도 존재하지 않는다.
    // 예매 요금을 계산하기 위해서는 현재 영화에 적용되어 있는 할인 정책의 종류를 판단할 수 있어야 한다.
    // 하지만 코드 어디에도 할인 정책을 판단하는 코드는 존재하지 않으며, 단지 discountPolicy에 메세지를 전송한다.
    // 이 코드에는 객체지향에서 가장 중요한 상속(inheritance), 다형성이라는 개념이 포함되어 있고, 
    // 그 기반에는 추상화(abstraction)라는 원리가 숨겨져 있다.
}