package uzvagontamir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uzvagontamir.model.MetrologiyaModel;

import java.util.List;

public interface MetrologiyaRepository extends JpaRepository<MetrologiyaModel, Integer> {

    @Query("SELECT u FROM MetrologiyaModel u WHERE u.depoNomi = ?1")
    List<MetrologiyaModel> findAllByDepoNomi(String depoNomi);
}
