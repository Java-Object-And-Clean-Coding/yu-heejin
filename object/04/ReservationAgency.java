public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();
        boolean discountTable = false;

        // DiscountCondition에 대해 루프를 돌면서 할인 가능 여부를 확인하는 for문
        for (DiscountCondition condition : movie.getDiscountConditions()) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                discountTable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) 
                    && condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0
                    && condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
            } else {
                discountTable = condition.getSequence() == screening.getSequence();
            }

            if (discountTable) {
                break;
            }
        }

        // discountTable 변수의 값을 체크하고 적절한 할인 정책에 따라 예매 요금을 계산하는 if
        Money fee;

        if (discountTable) {
            Money discountAmount = Money.ZERO;

            switch (movie.getMovieType()) {
                case AMOUNT_DISCOUNT:
                    discountAmount = movie.getDiscountAmount();
                    break;
                case PERCENT_DISCOUNT:
                    discountAmount = movie.getFee().times(movie.getDiscountPercent());
                    break;
                case NONE_DISCOUNT:
                    discountAmount = Money.ZERO;
                    break;
            }

            fee = movie.getFee().minus(discountAmount);
        } else {
            fee = movie.getFee();
        }

        return new Reservation(customer, screening, fee, audienceCount);
    }
}