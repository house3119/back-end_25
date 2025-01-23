package chapter2.friend_form_result.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import chapter2.friend_form_result.model.Friend;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class FriendController {
  public static List<Friend> friends = new ArrayList<Friend>();

  static {
    friends.add(new Friend("Minna", "Minnanen"));
    friends.add(new Friend("Tanja", "Tanjanen"));
    friends.add(new Friend("Jukka", "Jukkanen"));
  }

  @RequestMapping(value="*", method=RequestMethod.GET)
  public String requestMethodName() {
      return "redirect:/friends";
  }
  








  @RequestMapping(value="/friends", method=RequestMethod.GET)
  public String requestMethodName(Model model) {
    model.addAttribute("friends", friends);
    return "friends";
  }
  
  

  @RequestMapping(value="/add", method=RequestMethod.GET)
  public String showFriendForm(Model model) {
    model.addAttribute("friend", new Friend());
    return "friendform";
  }

  @RequestMapping(value="/newfriend", method=RequestMethod.POST)
  public String addNewFriend(Friend friend) {
    FriendController.friends.add(friend);
    return "redirect:/friends";
  }
  
}
