// 할인 정책 부모 클래스(추상 클래스)
public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();
    // 하나의 할인 정책은 여러개의 할인 조건을 포함할 수 있다.

    public DiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    // 전체 할인 조건에 대해 차례대로 isSatisfied를 호출한다.
    // 인자로 전달된 screening이 할인 조건을 만족시킬 경우는 true, 아니면 false
    // 할인 조건을 만족하는 조건이 하나라도 존재하면 추상 메서드인 getDiscountAmount를 호출해 할인 요금을 계산한다.
    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;   // 만족하는 조건이 없다면 할인 요금 0원 반환
    }

    abstract protected Money getDiscountAmount(Screening screening);
    // Q. 갑자기 헷갈리는데 private도 상속 가능했었나?
}