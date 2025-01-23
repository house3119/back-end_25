package kevat25.chapter2.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {

  @RequestMapping(value="/hello", method=RequestMethod.GET)
  public String HelloThymeleaf(Model model, @RequestParam String name, @RequestParam int age) {
    model.addAttribute("name", name);
    model.addAttribute("age", age);
    return "hello";
  }
  
}
