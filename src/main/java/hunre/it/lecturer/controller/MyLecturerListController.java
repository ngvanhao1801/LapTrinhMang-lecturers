package hunre.it.lecturer.controller;

import hunre.it.lecturer.service.MyLecturerListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyLecturerListController {
	@Autowired
	private MyLecturerListService service;

	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/my_lecturer";
	}

}
