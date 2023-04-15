// 관람객 개념 구현 클래스
public class Audience {
    private Bag bag;  // 관람객은 소지품을 보관하기 위해 가방을 소지할 수 있다.

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        if (bag.hasInvitation()) {
            bag.setTicket(ticket);
            return 0L;   // 티켓이 무료이므로 0 반환
        } else {
            bag.setTicket(ticket);
            bag.minusAmount(ticket.getFee());
            return ticket.getFee();   // 티켓 가격 반환
        }
    }

    // Bag에 접근하는 모든 로직을 Audience 내부로 감추기 위해 buy 메서드 추가
    // buy 메서드는 인자로 전달된 Ticket을 Bag에 넣은 후 지불된 금액을 반환한다.
    // 변경된 코드에서 Audience는 자신의 가방 안에 초대장이 들어있는지를 스스로 확인한다.
    // getBag() 메서드를 제거하고 결과적으로 Bag의 존재를 내부로 캡슐화 할 수 있다.
}
