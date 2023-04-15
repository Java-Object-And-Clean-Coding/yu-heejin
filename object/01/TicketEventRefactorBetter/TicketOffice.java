import java.util.Arrays;
import java.util.List;

// 매표소를 구현하는 클래스
public class TicketOffice {
    private Long amount;  // 판매금액
    private List<Ticket> tickets = new ArrayList<>();  // 판매하거나 교환해 줄 티켓의 목록

    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getTicket()));   // 티켓을 넘겨주고 받은 현금을 더해준다.
    }
    // 변경 후에는 TicketOffice가 Audience에게 직접 티켓을 판매하기 때문에 Audience에 관해 알아야 한다.

    private Ticket getTicket() {   // 티켓을 판매한다.
        return tickets.remove(0);
    }

    // 판매 금액을 더해준다.
    private void plusAmount(Long amount) {
        this.amount += amount;
    }

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    // 판매 금액을 차감한다.
    public void minusAmount(Long amount) {
        this.amount -= amount;
    }
}
