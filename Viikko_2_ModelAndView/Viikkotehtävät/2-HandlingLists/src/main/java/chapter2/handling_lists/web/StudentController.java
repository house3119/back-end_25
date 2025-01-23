package chapter2.handling_lists.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import chapter2.handling_lists.domain.Student;


@Controller
public class StudentController {

  @RequestMapping(value="/hello", method=RequestMethod.GET)
  public String showStudents(Model model) {
      List<Student> students = new ArrayList<Student>();
      students.add(new Student("Kate", "Cole"));
      students.add(new Student("Dan", "Brown"));
      students.add(new Student("Mike", "Mars"));

      model.addAttribute("students", students);
      
      return "studentlist";
  }

}
