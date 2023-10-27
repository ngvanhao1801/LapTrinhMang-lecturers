package hunre.it.lecturer.service;

import hunre.it.lecturer.entity.Lecturer;
import hunre.it.lecturer.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class LecturerService {

	@Autowired
	private LecturerRepository lRepo;

	public void save(Lecturer l) {
		lRepo.save(l);
	}

	public List<Lecturer> getAllLecturer() {
//		List<Lecturer> list = lRepo.findAll();
//
//		Collections.sort(list, Comparator.comparing(Lecturer::getHeSoLuong));
//
//		// Bổ sung cột tình trạng
//		for (Lecturer lecturer : list) {
//			if (lecturer.getHeSoLuong() >= 5) {
//				lecturer.setTinhTrang("Cao");
//			} else if (lecturer.getHeSoLuong() >= 3 && lecturer.getHeSoLuong() < 5) {
//				lecturer.setTinhTrang("Trung Bình");
//			} else {
//				lecturer.setTinhTrang("Thấp");
//			}
//		}
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
