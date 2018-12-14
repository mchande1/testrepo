package imagehoster.service;

import imagehoster.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void registerUser(User newUser){
        System.out.println("user will be saved to the db here");
    }

    public boolean checkLoginUser(User user){
        if(user.getUsername().equals("mohan")){
            return true;
        } else {
            return false;
        }
    }
}
