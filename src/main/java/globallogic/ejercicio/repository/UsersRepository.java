package globallogic.ejercicio.repository;

import globallogic.ejercicio.dto.UserDTO;
import globallogic.ejercicio.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByEmail(String email);

}
