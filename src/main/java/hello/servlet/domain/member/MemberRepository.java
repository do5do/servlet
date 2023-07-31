package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음. 실무에서는 ConcurrentHashMap, AtomicLong 사용을 고려해야 됨.
 */
public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    // singleton으로 구현 : 위 필드들을 static으로 구현할 필요는 없음.
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() { // 이 메서드로만 해당 객체 생성 가능
        return instance;
    }

    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        // 반환하는 리스트의 값을 밖에서 조작해도 store 자체가 변하지 않도록 새로운 리스트로 반환한다.
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
