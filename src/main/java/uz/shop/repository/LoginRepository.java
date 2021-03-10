package uz.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.shop.entities.LoginEntity;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public interface LoginRepository extends JpaRepository<LoginEntity,Long> {

}
