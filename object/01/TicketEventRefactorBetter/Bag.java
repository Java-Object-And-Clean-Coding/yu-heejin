// 관람객이 소지품을 보관할 Bag class
public class Bag {
    // 초대장, 티켓, 현금을 인스턴스 변수로 포함
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    // 아래의 메서드는 더 이상 외부에서 사용되지 않고 내부에서만 사용되기 때문에
    // 가시성을 private로 변경했다.
    // 아래의 작은 메서드들을 제거하지 않고 유지한 이유는
    // 코드의 중복을 제거하고 표현력을 높이기 위해서이다.
    private boolean hasInvitation() {
        return invitation != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    // Bag 인스턴스의 상태는 현금과 초대장을 함께 보관하거나 초대장 없이 현금만 보관하는 두 가지 상황
    // 인스턴스 생성 시점에 해당 제약을 강제하도록 생성자 추가
    public Bag(Long amount) {   // 이벤트에 당첨되지 않은 경우 (초대장 null)
        this(null, amount);
    }

    public Bag(Invitation invitation, Long amount) {  // 이벤트에 당첨된 경우 (초대장, 현금)
        this.invitation = invitation;
        this.amount = amount;
    }

    // 티켓의 소유 여부 판단
    public boolean hasTicket() {
        return ticket != null;
    }

    // 현금 증가
    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
