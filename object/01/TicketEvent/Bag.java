// 관람객이 소지품을 보관할 Bag class
public class Bag {
    // 초대장, 티켓, 현금을 인스턴스 변수로 포함
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    // Bag 인스턴스의 상태는 현금과 초대장을 함께 보관하거나 초대장 없이 현금만 보관하는 두 가지 상황
    // 인스턴스 생성 시점에 해당 제약을 강제하도록 생성자 추가
    public Bag(Long amount) {   // 이벤트에 당첨되지 않은 경우 (초대장 null)
        this(null, amount);
    }

    public Bag(Invitation invitation, Long amount) {  // 이벤트에 당첨된 경우 (초대장, 현금)
        this.invitation = invitation;
        this.amount = amount;
    }

    // 초대장 보유 여부 판단
    public boolean hasInvitation() {
        return invitation != null;
    }

    // 티켓의 소유 여부 판단
    public boolean hasTicket() {
        return ticket != null;
    }

    // 초대장을 티켓으로 교환
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    // 현금 감소(소비)
    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    // 현금 증가
    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
