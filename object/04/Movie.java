public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;
    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public Money getFee() {
        return fee;
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public List<DiscountCondition> getDiscountConditions() {
        return Collections.unmodifiableList(discountConditions);
    }

    public void setDiscountConditions(List<DiscountCondition> discountConditions) {
        this.discountConditions = discountConditions;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    } 
}

// 데이터 중심의 Movie 클래스 역시 책임 중심의 Movie클래스와 마찬가지로
// 영화를 표현하는 가장 기본적인 정보인 영화 제목, 상영시간, 기본 요금을 인스턴스 변수로 포함한다.
// 차이점은 할인 조건의 목록(discountConditions)이 인스턴스 변수로 Movie안에 직접 포함되어 있다는 것이다.
// 할인 정책을 DiscountPolicy라는 별도의 클래스로 분리했던 이전 예제와 달리 금액 할인 정책에 사용되는
// 할인 금액(discountAmount)과 비율 할인 정책에 사용되는 할인 비율(discountPercent)를 Movie안에 직접 정의하고 있다.

// 할인 정책은 영화별로 오직 하나만 지정할 수 있기 떄문에 한 시점에 discountAmount와 discountPercent 중
// 하나의 값만 사용될 수 있다.
// 영화에 사용된 할인 정책의 종류를 결정하는 것은 movieType

// 객체지향의 가장 중요한 원칙은 캡슐화이므로, 내부 데이터가 객체를 빠져나가 외부의 다른 객체들을
// 오염시키는 것을 막아야 한다.
// 이를 달성할 수 있는 가장 간단한 방법은 내부의 데이터를 반환하는 접근자와 데이터를 변경하는 수정자를 추가한다.