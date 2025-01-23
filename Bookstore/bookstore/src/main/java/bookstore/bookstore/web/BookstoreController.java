package bookstore.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookstoreController {

  @RequestMapping(value="index", method=RequestMethod.GET)
  public String getIndex() {
      return "index";
  }

  @RequestMapping(value="*", method=RequestMethod.GET)
  public String toIndex() {
      return "redirect:/index";
  }
  
}
