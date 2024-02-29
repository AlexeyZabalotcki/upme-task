package by.upmebel.upmecutfile.upmetask.dao;

import by.upmebel.upmecutfile.upmetask.model.Hole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoleRepository extends JpaRepository<Hole, Long> {
}
