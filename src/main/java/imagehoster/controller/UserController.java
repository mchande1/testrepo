package imagehoster.controller;

import imagehoster.model.Image;
import imagehoster.model.User;
import imagehoster.model.UserProfile;
import imagehoster.service.ImageService;
import imagehoster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userservice;

    @Autowired
    private ImageService imageService;

    @RequestMapping("users/registration")
    public String registration(Model model){
        UserProfile profile = new UserProfile();
        User user = new User();
        user.setProfile(profile);
        model.addAttribute("User", user);
        return "users/registration";
    }

    @RequestMapping(value = "users/registration", method = RequestMethod.POST)
    public String registerUser(User user, Model model){
        userservice.registerUser(user);

        List<Image> imageList = new ArrayList<>();
        imageList = imageService.getAllImages();
        model.addAttribute("images", imageList);
        return "index";
    }

    @RequestMapping(value = "users/login")
    public String login(){
        return "users/login";
    }

    @RequestMapping(value = "users/login", method = RequestMethod.POST)
    public String loginUser(User User, Model model){
        boolean isUserPresent = userservice.checkLoginUser(User);
        System.out.println("**is user present: " + isUserPresent);
        if(isUserPresent){
            List<Image> imageList = new ArrayList<>();
            imageList = imageService.getAllImages();
            model.addAttribute("images", imageList);
            return "images";
        } else {
            return "users/login";
        }
    }
}
