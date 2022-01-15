package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepoTest {

    MemberRepo memberRepo = MemberRepo.getInstance();
    @AfterEach
    void afterEach(){
        memberRepo.clearStore();;
    }

    @Test
    void save() {
        //given
        Member member = new Member("hello", 22);
        //when
        Member saveMember = memberRepo.save(member);
        //then
        Member findMember = memberRepo.findById(saveMember.getId());
        Assertions.assertThat(saveMember).isEqualTo(findMember);
    }



    @Test
    void findAll() {
        //given
        Member member1 = new Member("member1", 11);
        Member member2 = new Member("member2", 21);
        memberRepo.save(member1);
        memberRepo.save(member2);

        //when
        List<Member> result = memberRepo.findAll();

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).contains(member1,member2);
    }


}