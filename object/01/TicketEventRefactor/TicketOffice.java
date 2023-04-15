import java.util.Arrays;
import java.util.List;

// 매표소를 구현하는 클래스
public class TicketOffice {
    private Long amount;  // 판매금액
    private List<Ticket> tickets = new ArrayList<>();  // 판매하거나 교환해 줄 티켓의 목록

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public Ticket getTicket() {   // 티켓을 판매한다.
        return tickets.remove(0);
    }

    // 판매 금액을 차감한다.
    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    // 판매 금액을 더해준다.
    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
