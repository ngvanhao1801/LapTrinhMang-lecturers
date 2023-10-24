package hunre.it.lecturer.service;

import hunre.it.lecturer.entity.MyLecturerList;
import hunre.it.lecturer.repository.MyLecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyLecturerListService {

	@Autowired
	private MyLecturerRepository myLecturer;

	public void saveMyLecturers(MyLecturerList lecturerList) {
		myLecturer.save(lecturerList);
	}

	public List<MyLecturerList> getAllMyLecturers() {
		return myLecturer.findAll();
	}

	public void deleteById(int id) {
		myLecturer.deleteById(id);
	}

}
