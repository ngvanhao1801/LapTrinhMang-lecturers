package hunre.it.lecturer.controller;

import hunre.it.lecturer.entity.Lecturer;
import hunre.it.lecturer.service.LecturerService;
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

  private boolean isEdit = false;

  private String errorMessage = "";

  @GetMapping("/")
  public String home() {
    return "home";
  }

  @GetMapping("/lecturer_register")
  public String lecturerRegister(Model model) {
    model.addAttribute("errorMessage", errorMessage);

    return "lecturer-register";
  }

  @GetMapping("/available_lecturers")
  public ModelAndView getAllLecturer() {
    List<Lecturer> list = service.getAllLecturer();

    return new ModelAndView("lecturer-list", "lecturer", list);
  }

  @RequestMapping("/editLecturer/{maGv}")
  public String editLecturer(@PathVariable("maGv") int maGv, Model model) {
    Lecturer lecturer = service.getLecturerById(maGv);
    model.addAttribute("lecturer", lecturer);

    isEdit = true;

    return "lecturer-edit";
  }

  @RequestMapping("/deleteLecturer/{maGv}")
  public String deleteLecturer(@PathVariable("maGv") int maGv) {
    service.deleteByMaGv(maGv);

    return "redirect:/available_lecturers";
  }

  @GetMapping("/search")
  public String searchLecturer(@RequestParam("tenBoMon") String tenBoMon,
                               @RequestParam("heSoLuong") int heSoLuong,
                               Model model) {
    List<Lecturer> lecturers = service.searchLecturer(tenBoMon, heSoLuong);
    model.addAttribute("lecturer", lecturers);

    return "search-lecturer";
  }

  @PostMapping("/save")
  public String addLecturer(@ModelAttribute Lecturer lecturer, Model model) {
    errorMessage = "";
    if (!isEdit && service.existsById(lecturer.getMaGv())) {
      isEdit = false;
      errorMessage = "Đã tồn tại id = " + lecturer.getMaGv();
      model.addAttribute("lecturer", lecturer);
      return "redirect:/lecturer_register";
    }

    service.save(lecturer);
    return "redirect:/available_lecturers";
  }

}
