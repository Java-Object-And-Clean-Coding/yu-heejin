public enum DiscountConditionType {
    SEQUENCE,  // 순번 조건: 상영 순번을 이용해 할인 여부를 판단
    PERIOD   // 기간 조건: 상영 시간을 이용해 할인 여부 판단
}

// 영화 예매 도메인에는 순번 조건과 기간 조건이라는 두 가지 종류의 할인 조건이 존재한다.