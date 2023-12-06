package hunre.it.lecturer.service;

import hunre.it.lecturer.entity.Lecturer;
import hunre.it.lecturer.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerService {

	@Autowired
	private LecturerRepository repository;

	public void save(Lecturer l) {
		repository.save(l);
	}

	public List<Lecturer> getAllLecturer() {
		return repository.findAll();
	}

	public Lecturer getLecturerById(int maGv) {
		return repository.findById(maGv).get();
	}

	public boolean existsById(int maGv) {
		return repository.existsById(maGv);
	}

	public void deleteByMaGv(int maGv) {
		repository.deleteById(maGv);
	}

	public List<Lecturer> searchLecturer(String tenBoMon, int heSoLuong) {
		return repository.findByTenBoMonAndHeSoLuongLessThanEqual(tenBoMon, heSoLuong);
	}

}
