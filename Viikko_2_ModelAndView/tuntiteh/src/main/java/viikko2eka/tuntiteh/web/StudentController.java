package viikko2eka.tuntiteh.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import viikko2eka.tuntiteh.domain.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class StudentController {

  public static List<Student> opiskelijat = new ArrayList<Student>();

  static {
    opiskelijat.add(new Student("Pekka", "Virtainen"));
    opiskelijat.add(new Student("Kakka", "Virtainen"));
    opiskelijat.add(new Student("Marko", "Kakkanen"));
  }

  @RequestMapping(value="/hello", method=RequestMethod.GET)
  public String showStudents(Model model) {
    model.addAttribute("students", opiskelijat);
    return "studentlist";
  }
  
}
