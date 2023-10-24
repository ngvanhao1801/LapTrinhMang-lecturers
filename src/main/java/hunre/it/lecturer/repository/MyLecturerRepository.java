package hunre.it.lecturer.repository;


import hunre.it.lecturer.entity.MyLecturerList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyLecturerRepository extends JpaRepository<MyLecturerList, Integer> {
}
