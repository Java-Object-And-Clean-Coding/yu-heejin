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
        // if (discountPolicy == null) {
        //     return fee;
        // }
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
    // 해당 메서드에는 이상한 점이 존재하는데, 어떤 할인 정책을 사용할 것인지 결정하는 코드가 어디에도 존재하지 않는다.
    // 예매 요금을 계산하기 위해서는 현재 영화에 적용되어 있는 할인 정책의 종류를 판단할 수 있어야 한다.
    // 하지만 코드 어디에도 할인 정책을 판단하는 코드는 존재하지 않으며, 단지 discountPolicy에 메세지를 전송한다.
    // 이 코드에는 객체지향에서 가장 중요한 상속(inheritance), 다형성이라는 개념이 포함되어 있고, 
    // 그 기반에는 추상화(abstraction)라는 원리가 숨겨져 있다.

    // 할인 정책이 적용되어 있지 않은 경우 계산할 필요 없이 영화에 설정된 기본 금액을 그대로 사용하면 된다.
    // 이러한 방식의 문제점은 할인 정책이 없는 경우를 예외 케이스로 취급하기 때문에
    // 지금까지 일관성 있던 협력 방식이 무너지게 된다.
    // 기존 할인 정책의 경우 할인할 금액을 계산하는 책임이 DiscountPolicy의 자식 클래스에 있었지만
    // 할인 정책이 없는 경우에는 할인 금액이 0원이라는 사실을 결정하는 책임이 Movie에 있기 때문이다.
    // 따라서 책임의 위치를 결정하기 위해 조건문을 사용하는 것은 협력의 설계 측면에서 대부분의 경우 좋지 않은 선택이다.
    // 항상 예외 케이스를 최소화하고 일관성을 유지할 수 있는 방법을 선택하라.
}