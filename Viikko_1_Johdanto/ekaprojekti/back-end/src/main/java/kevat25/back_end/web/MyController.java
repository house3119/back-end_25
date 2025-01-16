package kevat25.back_end.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MyController {

  @RequestMapping("main")
  @ResponseBody
  public String returnMessage() {
      return "Eka Spring Boot sovellus!";
  }

  @RequestMapping("sayHello")
  @ResponseBody
  public String returnGreeting(@RequestParam (name="nimesi", required = false, defaultValue = "Marko") String etunimi, @RequestParam int age) {
      return "Moikka " + etunimi + ", " + age + " vuotta";
  }

}
