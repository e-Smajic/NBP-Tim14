package ba.unsa.etf.confix_be.services;

import ba.unsa.etf.confix_be.core.services.BaseCRUDService;
import ba.unsa.etf.confix_be.entities.UserEntity;
import ba.unsa.etf.confix_be.mappers.UserMapper;
import ba.unsa.etf.confix_be.payloads.request.auth.RegisterRequest;
import ba.unsa.etf.confix_be.payloads.request.insert.UserInsertRequestDto;
import ba.unsa.etf.confix_be.payloads.request.search.UserSearchRequestDto;
import ba.unsa.etf.confix_be.payloads.request.update.UserUpdateRequestDto;
import ba.unsa.etf.confix_be.payloads.response.UserResponseDto;
import ba.unsa.etf.confix_be.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Getter
@Service
@RequiredArgsConstructor
public class UserService implements
        BaseCRUDService<UserEntity, UserResponseDto, UserSearchRequestDto, UserInsertRequestDto, UserUpdateRequestDto, Long> {

    private static final Long CUSTOMER_ROLE_ID = 401L; // Confix-Customer

    private final UserRepository repository;
    private final UserMapper mapper;
    private final EntityManager entityManager;
    private final PasswordEncoder passwordEncoder;

    /* ───────────────────────────────────────────────────── */
    /* BaseCRUDService requirement */
    /* ───────────────────────────────────────────────────── */

    @Override
    public Class<UserEntity> getEntityClass() {
        return UserEntity.class;
    }

    /* ───────────────────────────────────────────────────── */
    /* Registration logic */
    /* ───────────────────────────────────────────────────── */

    /**
     * Creates a new Confix-Customer account.
     * 
     * @throws IllegalStateException "username-taken", "email-taken", or
     *                               "username-or-email-taken"
     */
    public UserEntity register(RegisterRequest dto) {
        // 1) Basic lookups
        repository.findByUsername(dto.username())
                .ifPresent(u -> {
                    throw new IllegalStateException("username-taken");
                });
        repository.findByEmail(dto.email())
                .ifPresent(u -> {
                    throw new IllegalStateException("email-taken");
                });

        // 2) Build entity
        var user = new UserEntity();
        user.setFirstName(dto.firstName());
        user.setLastName(dto.lastName());
        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setPhoneNumber(dto.phoneNumber());
        user.setBirthDate(dto.birthDate());
        user.setRoleId(CUSTOMER_ROLE_ID);

        // 3) Save with a safety net for any DB‐level uniqueness race
        try {
            return repository.save(user);
        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
            // catches ORA-00001 (unique constraint) or other integrity errors
            throw new IllegalStateException("username-or-email-taken");
        }
    }
}
