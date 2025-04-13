package ba.unsa.etf.confix_be.services;

import ba.unsa.etf.confix_be.core.services.BaseCRUDService;
import ba.unsa.etf.confix_be.entities.UserEntity;
import ba.unsa.etf.confix_be.mappers.UserMapper;
import ba.unsa.etf.confix_be.payloads.request.insert.UserInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.UserSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.UserUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.UserResponseDto;
import ba.unsa.etf.confix_be.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@RequiredArgsConstructor
public class UserService implements BaseCRUDService<UserEntity, UserResponseDto, UserSearchRequestDto, UserInsertRequestDto, UserUpdateRequestDto, Long> {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final EntityManager entityManager;

    @Override
    public Class<UserEntity> getEntityClass() {
        return UserEntity.class;
    }
}
