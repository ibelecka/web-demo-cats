package lv.accenture.bootcamp.webdemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import lv.accenture.bootcamp.webdemo.model.Cat;

@Repository
public interface CatsRepository extends CrudRepository<Cat, Long> {

	List<Cat> findByNickname(String nickname);



}
