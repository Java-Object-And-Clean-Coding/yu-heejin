public enum MovieType {
    AMOUNT_DISCOUNT,  // discountAmount
    PERCENT_DISCOUNT,  // discountPercent
    NONE_DISCOUNT,  // 할인 정책을 적용하지 말 것
}

// Movie가 할인 금액을 계산하는데 필요한 데이터는 무엇인가?
// 금액 할인 정책의 경우 할인 금액이 필요하고 비율 할인 정책의 경우 할인 비율이 필요하다.
// 예매 가격을 계산하기 위해서는 Movie에 설정된 할인 정책이 뭔지 알아야 한다.
// 이를 위해 MovieType을 정의하고 이 타입의 인스턴스를 속성으로 포함시켜 이 값에 따라 어떤 데이터를 사용할지 결정한다.