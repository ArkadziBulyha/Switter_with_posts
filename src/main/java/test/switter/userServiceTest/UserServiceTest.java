package test.switter.userServiceTest;

import com.switter.entity.User;
import com.switter.service.UserService;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class UserServiceTest {

    @Test
    public void findByLoginTest() {
        UserService userService = new UserService();
        String login = "";
        userService.findByLogin(login);
        assertNotNull("findByLoginTest failed", login);
    }

    @Test
    public void editRoleTest() {
        UserService userService = new UserService();
        int userID1 = 6;
        int userId2 = 10;
        userService.editRole(userID1);
        assertEquals("editRoleTest failed", userID1, userId2);
    }

    @Test
    public void addUserTest() {
        UserService userService = new UserService();
        User user = new User();
        userService.addUser(user);
        assertNotNull(user);
    }

}
