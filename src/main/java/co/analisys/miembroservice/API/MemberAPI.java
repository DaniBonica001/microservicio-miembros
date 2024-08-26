package co.analisys.miembroservice.API;

import co.analisys.miembroservice.DTO.CreateMemberDTO;
import co.analisys.miembroservice.model.Member;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping(MemberAPI.BASE_URL)
public interface MemberAPI {

    String BASE_URL = "/members";

    @PostMapping
    Member createMember(@RequestBody CreateMemberDTO member);

    @GetMapping("/{memberId}")
    Member getMemberById(@PathVariable String memberId);

    @GetMapping("/all")
    List<Member> getAllMembers();

    @PutMapping("/{memberId}")
    Member UpdateSubscription(@PathVariable String memberId);




}
