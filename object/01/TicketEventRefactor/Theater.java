// 소극장
public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }

    // 수정된 Theater 클래스 어디서도 ticketOffice에 접근하지 않는다는 사실에 주목하라
    // Theater는 ticketOffice가 TicketSeller 내부에 존재한다는 사실을 알지 못한다.
    // Theater는 단지 ticketSeller가 sellTo 메세지를 이해하고 응답할 수 있다는 사실만 알고 있다.
}
