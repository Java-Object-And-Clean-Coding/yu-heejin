// 순번 조건 클래스 구현
public class SequenceCondition implements DiscountCondition {
    private int sequence;   // 할인 여부를 판단하기 위해 사용할 순번을 인스턴스 변수로 포함한다.

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    // 파라미터로 전달된 screening의 상영 순번과 일치할 경우 할인 가능한 것으로 판단하여 true 반환
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}