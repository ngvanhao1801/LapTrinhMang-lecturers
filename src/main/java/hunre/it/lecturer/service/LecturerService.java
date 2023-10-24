package hunre.it.lecturer.service;

import hunre.it.lecturer.entity.Lecturer;
import hunre.it.lecturer.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerService {

	@Autowired
	private LecturerRepository lRepo;

	public void save(Lecturer l) {
		lRepo.save(l);
	}

	public List<Lecturer> getAllLecturer() {
		return lRepo.findAll();
	}

	public Lecturer getLecturerById(int id) {
		return lRepo.findById(id).get();
	}

	public void deleteById(int id) {
		lRepo.deleteById(id);
	}

	public List<Lecturer> searchLecturer(String tenBoMon, int heSoLuong) {
		return lRepo.findByTenBoMonAndHeSoLuongLessThanEqual(tenBoMon, heSoLuong);
	}

}
