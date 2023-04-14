// 공연을 관람하기 원하는 모든 사람들은 티켓을 소지하고 있어야 한다.
public class Ticket {
    private Long fee;   // Q: long이 아닌 Long을 사용한 이유는?

    public Long getFee() {
        return fee;
    }
}
