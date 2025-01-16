package kevat25.chapter1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MyController {

  @RequestMapping("index")
  @ResponseBody
  public String indexMethod() {
      return "This is the main page";
  }

  @RequestMapping("contact")
  @ResponseBody
  public String contactMethod() {
      return "This is the contact page";
  }
  
  @RequestMapping("hello")
  @ResponseBody
  public String requestMethodName(@RequestParam String location, @RequestParam String name) {
      return "Welcome to the " + location + " " + name;
  }
  
}
