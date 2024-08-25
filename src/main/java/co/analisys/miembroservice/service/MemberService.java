package co.analisys.miembroservice.service;

import co.analisys.miembroservice.DTO.CreateMemberDTO;
import co.analisys.miembroservice.Mapper.MemberMapper;
import co.analisys.miembroservice.model.Member;
import co.analisys.miembroservice.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public Member createMember(CreateMemberDTO member) {
        Member newMember = memberMapper.fromCreateMemberDTO(member);
        newMember.setActive(true);
        return memberRepository.save(newMember);
    }

    public Member getMemberById(String memberId) {
        return memberRepository.findById(Long.parseLong(memberId))
                .orElseThrow(() -> new RuntimeException("Miembro no encontrado"));
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member updateSubscription(String memberId) {
        Member member = memberRepository.findById(Long.parseLong(memberId))
                .orElseThrow(() -> new RuntimeException("Miembro no encontrado"));
        member.setActive(!member.isActive());
        return memberRepository.save(member);

    }
}



