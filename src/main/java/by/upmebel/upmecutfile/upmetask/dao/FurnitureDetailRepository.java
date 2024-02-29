package by.upmebel.upmecutfile.upmetask.dao;

import by.upmebel.upmecutfile.upmetask.model.FurnitureDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureDetailRepository extends JpaRepository<FurnitureDetail, Long> {
}
