package globallogic.ejercicio.repository;

import globallogic.ejercicio.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByEmail(String email);

    UserEntity findByToken(String token);
    @Query("update UserEntity u set u.lastLogin=?2, u.token=?3 where u.email=?1")
    UserEntity updateUser(String email, String lastLogin, String token);

//    @Query("update UserEntity u set u.lastLogin = :lastLogin, u.token = :token where u.email = :email")
//    @Modifying
//    int updateUser(@Param("email") String email, @Param("lastLogin") String lastLogin, @Param("token") String token);
}
