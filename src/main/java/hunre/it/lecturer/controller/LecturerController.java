package hunre.it.lecturer.controller;

import hunre.it.lecturer.entity.Lecturer;
import hunre.it.lecturer.entity.MyLecturerList;
import hunre.it.lecturer.service.LecturerService;
import hunre.it.lecturer.service.MyLecturerListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LecturerController {

	@Autowired
	private LecturerService service;

	@Autowired
	private MyLecturerListService myLecturerListService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/lecturer_register")
	public String lecturerRegister() {
		return "lecturer-register";
	}

	@GetMapping("/available_lecturers")
	public ModelAndView getAllLecturer() {
		List<Lecturer> list = service.getAllLecturer();

		return new ModelAndView("lecturer-list", "lecturer", list);
	}

	@PostMapping("/save")
	public String addLecturer(@ModelAttribute Lecturer l) {
		service.save(l);
		return "redirect:/available_lecturers";
	}

	@GetMapping("/my_lecturers")
	public String getMyLecturers(Model model) {
		List<MyLecturerList> list = myLecturerListService.getAllMyLecturers();
		model.addAttribute("lecturer", list);
		return "my-lecturer";
	}

	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Lecturer l = service.getLecturerById(id);
		MyLecturerList ml = new
				MyLecturerList(l.getId(), l.getMaGv(), l.getHoTen(), l.getTenBoMon(), l.getHeSoLuong());
		myLecturerListService.saveMyLecturers(ml);
		return "redirect:/my_lecturers";
	}

	@RequestMapping("/editLecturer/{id}")
	public String editLecturer(@PathVariable("id") int id, Model model) {
		Lecturer l = service.getLecturerById(id);
		model.addAttribute("lecturer", l);
		return "lecturer-edit";
	}

	@RequestMapping("/deleteLecturer/{id}")
	public String deleteLecturer(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/available_lecturers";
	}

	@GetMapping("/search")
	public String searchLecturer(@RequestParam("tenBoMon") String tenBoMon,
	                             @RequestParam("heSoLuong") int heSoLuong,
	                             Model theModel) {
		List<Lecturer> lecturers = service.searchLecturer(tenBoMon, heSoLuong);
		theModel.addAttribute("lecturer", lecturers);
		return "search-lecturer";
	}

}
