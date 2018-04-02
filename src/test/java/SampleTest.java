import controllers.UserController;
import models.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by asok on 4/2/2018.
 */
public class SampleTest {
    UserController userController;

    @Before
    public void setUp(){
        userController = new UserController();
    }

    @Test
    public void testUserInfoResponce(){
        User user = userController.getUserByName("maxkolotilkin");
        assertEquals(user.getHtml_url(), "https://github.com/maxkolotilkin");
    }

    @Test
    public void testFollowers() {
        User[] followers = userController.getFollowersByUser("Mak0");
        assertEquals(15, followers.length);
    }
}
