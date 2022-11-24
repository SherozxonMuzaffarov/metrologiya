package uzvagontamir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uzvagontamir.model.TransportModel;

import java.util.List;

public interface TransportRepository extends JpaRepository<TransportModel, Integer> {

    @Query("SELECT u FROM TransportModel u WHERE u.depoNomi = ?1")
    List<TransportModel> findByDepoNomi(String depoNomi);
}
