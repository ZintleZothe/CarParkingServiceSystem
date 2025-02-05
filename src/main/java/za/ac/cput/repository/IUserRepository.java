package za.ac.cput.repository;
/** IUserRepository.java
 * Author: Abongile Tshopi (214254151)
 * Date: 09 April 2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.User;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
 //   public List<User> getAll();
}