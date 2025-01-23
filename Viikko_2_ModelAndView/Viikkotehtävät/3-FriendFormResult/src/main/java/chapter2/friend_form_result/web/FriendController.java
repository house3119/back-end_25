package chapter2.friend_form_result.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import chapter2.friend_form_result.model.Friend;


@Controller
public class FriendController {

  @RequestMapping(value="/add", method=RequestMethod.GET)
  public String showFriendForm(Model model) {
    model.addAttribute("friend", new Friend());
    return "friendform";
  }

  @RequestMapping(value="/newfriend", method=RequestMethod.POST)
  public String addNewFriend(Friend friend) {
    return "result";
  }
  
}
