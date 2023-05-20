Movie avatar = new Movie("아바타", 
    Duration.ofMinutes(120),
    Money.wons(10000),
    // 하나의 할인 정책에 여러개의 할인 조건을 설정
    // Q. 자바 인터페이스 구현 시 타입 설정
    new AmountDiscountPolicy(Money.wons(800), new SequenceCondition(1), new SequenceCondition(10),
        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
    )
);
// 영화 아바타에 대한 할인 정책과 할인 조건을 설정한 코드이다.
// 할인 정책으로 금액 할인 정책이 적용되고, 두 개의 순서 조건과 두 개의 기간 조건을 이용해 할인 여부를 판단한다는 것을 알 수 있다.


Movie titanic = new Movie("타이타닉",
    Duration.ofMinutes(180),
    Money.wons(11000),
    new PercentDiscountPolicy(0.1,
        new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
        new SequenceCondition(2),
        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))
    )
);

// 할인되지 않는 영화 생성
Movie starWars = new Movie("스타워즈",
    Duration.ofMinutes(210),
    Money.wons(10000),
    new NoneDiscountPolicy()
)

// 기존 코드를 수정하지 않고 NoneDiscountPolicy 클래스를 추가하는 것만으로 애플리케이션의 기능을 확장
// 이처럼 추상화를 중심으로 코드의 구조를 설계하면 유연하고 확장 가능한 설계를 만들 수 있다.