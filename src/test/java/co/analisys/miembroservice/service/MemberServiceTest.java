package co.analisys.miembroservice.service;

import co.analisys.miembroservice.DTO.CreateMemberDTO;
import co.analisys.miembroservice.Mapper.MemberMapper;
import co.analisys.miembroservice.model.Member;
import co.analisys.miembroservice.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private MemberMapper memberMapper;

    public MemberServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMemberByIdNotFound() {
        when(memberRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            memberService.getMemberById("1");
        });
        assertEquals("Miembro no encontrado", thrown.getMessage());
    }

    @Test
    void testGetAllMembers() {
        // Implement this test similarly to the above ones
    }

    @Test
    void testUpdateSubscription() {
        // Implement this test similarly to the above ones
    }

}
