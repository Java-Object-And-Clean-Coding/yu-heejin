// 상영 시작 시간이 특정 기간 안에 포함되는지 여부를 판단해 할인 여부를 결정한다.
public class PeriodCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek;  // 사용할 요일
    private LocalTime startTime;  // 시작 시간
    private LocalTime endTime;  // 종료 시간

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // 인자로 전달된 screening의 상영 요일이 dayOfWeek와 같고, 상영 시작 시간이 startTime, endTime 사이에 있을 경우 true
    // startTime <= a <= endTime
    /*
        compareTo
        기준 값과 비교대상이 동일한 값일 경우 0
        기준 값이 비교대상 보다 작은 경우 -1
        기준 값이 비교대상 보다 큰 경우 1
     */
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
            startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 &&
            endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
    }
}