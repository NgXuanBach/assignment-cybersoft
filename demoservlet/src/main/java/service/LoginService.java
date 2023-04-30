package service;

import model.UserModel;
import repository.UserRepository;

import java.util.List;

// Trên giao diện có bao nhiêu tính năng thì mình sẽ\
// có bấy nhiêu cái function nằm trong này.
public class LoginService {
    private UserRepository userRepository = new UserRepository();

    public boolean checkLogin(String email, String password) {
        List<UserModel> list = userRepository.findByEmailAndPassword(email, password);
        return list.size() > 0;
    }
    /**
     * Tạo ra 1 link /user load giao diện user-table.jsp
     * UserController lấy được danh sách user
     */
}
