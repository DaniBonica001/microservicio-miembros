package co.analisys.miembroservice.Mapper;

import co.analisys.miembroservice.DTO.CreateMemberDTO;
import co.analisys.miembroservice.model.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member fromCreateMemberDTO(CreateMemberDTO createMemberDTO);
}
