package imagehoster.controller;

import imagehoster.model.Image;
import imagehoster.service.HardCodedImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class ImageController {

    @Autowired
    private HardCodedImage hardCodedImage;

    @RequestMapping("/images/{title}")
    public String showImage(@PathVariable String title, Model model){
        Date date = new Date();
        Image image = null;
        if (title.equals("Dr. Strange")) {
            image = new Image(1, "Dr. Strange",hardCodedImage.getDrStrange(),"Dr. Strange has a time stone", date);
        } else if (title.equals("SpiderMan")) {
            image = new Image(2, "SpiderMan", hardCodedImage.getSpiderMan(), "Spider man dies in Infinity War",date);
        }

        model.addAttribute("image", image);
        return "images/image";
    }
}
