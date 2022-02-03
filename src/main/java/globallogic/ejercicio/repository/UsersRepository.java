package globallogic.ejercicio.repository;

import globallogic.ejercicio.dto.UserDTO;
import globallogic.ejercicio.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity,Long> {

    @Query("select u.email from UserEntity u where u.email =?1")
    Boolean findIdByEmail(String email);









}
