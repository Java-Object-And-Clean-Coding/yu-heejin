// 티켓 판매원
public class TicketSeller {
    private TicketOffice ticketOffice;   // 자신이 일하는 매표소

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        // 매표소에서 티켓을 꺼내고 관중에게 티켓값을 받아서 매표소에 현금을 더해준다.
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
    }

    // TicketSeller에서 getTicketOffice 메서드가 제거됐다는 사실에 주목하라.
    // ticketOffice의 가시성이 private이고 접근 가능한 퍼블릭 메서드가 더 이상 존재하지 않기 때문에
    // 외부에서는 ticketOffice에 직접 접근할 수 없다.
    // 결과적으로 ticketOffice에 대한 접근은 오직 TicketSeller안에만 존재한다.
    // 이처럼 개념적이나 물리적으로 객체 내부의 세부적인 사항을 감추는 것을 캡슐화(encapsulation)라 한다.
}
