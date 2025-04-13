package ba.unsa.etf.confix_be.controllers;

import ba.unsa.etf.confix_be.core.controllers.BaseCRUDController;
import ba.unsa.etf.confix_be.entities.UserEntity;
import ba.unsa.etf.confix_be.payloads.request.insert.UserInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.UserSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.UserUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.UserResponseDto;
import ba.unsa.etf.confix_be.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
@RequestMapping("/api/users")
@Tag(name = "users", description = "Users controller")
@RequiredArgsConstructor
public class UserController implements BaseCRUDController<UserEntity, UserResponseDto, UserSearchRequestDto, UserInsertRequestDto, UserUpdateRequestDto, Long> {
    private final UserService service;
}
