package co.analisys.miembroservice.API;

import co.analisys.miembroservice.DTO.CreateMemberDTO;
import co.analisys.miembroservice.model.Member;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping(MemberAPI.BASE_URL)
public interface MemberAPI {

    String BASE_URL = "/members";

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(
            summary = "Crear un nuevo miembro",
            description = "Este endpoint permite crear un nuevo miembro proporcionando los detalles en el cuerpo de la solicitud."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Miembro creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada no válidos"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    Member createMember(@RequestBody CreateMemberDTO member);

    @GetMapping("/{memberId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TRAINER')")
    @Operation(
            summary = "Obtener miembro por ID",
            description = "Este endpoint permite obtener los detalles de un miembro proporcionando su ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Miembro recuperado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Miembro no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    Member getMemberById(@PathVariable String memberId);

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TRAINER')")
    @Operation(
            summary = "Obtener todos los miembros",
            description = "Este endpoint permite obtener una lista de todos los miembros registrados."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Miembros recuperados exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    List<Member> getAllMembers();

    @PutMapping("/{memberId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TRAINER')")
    @Operation(
            summary = "Actualizar suscripción de un miembro",
            description = "Este endpoint permite actualizar la suscripción de un miembro proporcionando su ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Suscripción actualizada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Miembro no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    Member UpdateSubscription(@PathVariable String memberId);




}
