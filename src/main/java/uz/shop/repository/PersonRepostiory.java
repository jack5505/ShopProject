package uz.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.shop.entities.PersonEntity;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public interface PersonRepostiory extends JpaRepository<PersonEntity,Long> {

}
