package imagehoster.controller;

import imagehoster.model.Image;
import imagehoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ImageService imageservice;

    @RequestMapping("/")
    public String createIndex(Model model){

        List<Image> imageList = new ArrayList<>();
        imageList = imageservice.getAllImages();
        model.addAttribute("images", imageList);
        return "index";
    }
}
