package hunre.it.lecturer.repository;


import hunre.it.lecturer.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {

  List<Lecturer> findByTenBoMonAndHeSoLuongLessThanEqual(String tenBoMon, int heSoLuong);

}
