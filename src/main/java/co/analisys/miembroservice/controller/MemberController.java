package co.analisys.miembroservice.controller;

import co.analisys.miembroservice.API.MemberAPI;
import co.analisys.miembroservice.DTO.CreateMemberDTO;
import co.analisys.miembroservice.model.Member;
import co.analisys.miembroservice.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MemberController implements MemberAPI {

    private final MemberService memberService;

    @Override
    public Member createMember(CreateMemberDTO member) {
        return memberService.createMember(member);
    }

    @Override
    public Member getMemberById(String memberId) {
        return memberService.getMemberById(memberId);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @Override
    public Member UpdateSubscription(String memberId) {
        return memberService.updateSubscription(memberId);
    }
}
