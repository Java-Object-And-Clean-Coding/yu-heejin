// 티켓 판매원
public class TicketSeller {
    private TicketOffice ticketOffice;   // 자신이 일하는 매표소

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        ticketOffice.sellTicketTo(audience);
    }

    // TicketSeller는 TicketOffice의 구현이 아닌 인터페이스에만 의존한다.
    // 하지만 위와 같은 변경은 TicketOffice와 Audience 사이에 의존성이 추가됐다.
    // 변경 전에는 TicketOffice가 Audience에 대해 알지 못했다.
}
