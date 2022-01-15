package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepo {

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepo instance = new MemberRepo();

    public static MemberRepo getInstance(){
        return instance;
    }
    //싱글톤이기 때문에 생성자를 private로 설정해 아무나 생성할 수 없게함
    private MemberRepo(){

    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
