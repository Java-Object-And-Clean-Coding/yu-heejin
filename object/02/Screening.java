// 상영
public class Screening {
    private Movie movie;   // 상영할 영화
    private int sequence;  // 순번
    private LocalDateTime whenScreened;  // 상영 시작 시간

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    // 상영 시작 시간을 반환한다.
    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    // 순번의 일치 여부를 검사한다.
    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    // 기본 요금을 반환한다.
    public Money getMovieFee() {
        return movie.getFee();
    }

    // 영화를 예매한 후 예매 정보를 담고 있는 Reservation의 인스턴스를 생성해서 반환한다.
    // customer는 예매자에 대한 정보를 담고 있으며, audienceCount는 인원수이다.
    // calculateFee라는 private 메서드를 호출해서 요금을 계산한 후 그 결과를 Reservation의 생성자에 전달하는 것을 알 수 있다.
    public Reservation reserve(Customer Customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    // calculateFee 메서드는 요금을 계산하기 위해 다시 Movie의 calculateMovieFee 메서드를 호출한다.
    // Movie의 calculateMovieFee 메서드의 반환값은 1인당 예매 요금이다.
    // 따라서 Screening은 전체 예매 요금을 구하기 위해 calculateMovieFee 메서드의 반환 값에 인원 수인 audienceCount를 곱한다.
    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}