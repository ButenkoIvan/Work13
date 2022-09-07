package HW13;

import java.io.IOException;
import java.net.URI;

public class Main {
    private static final String URI_USERS = "https://jsonplaceholder.typicode.com/users";
    private static final String URI_SITE = "https://jsonplaceholder.typicode.com/";


    public static void main(String[] args) throws IOException, InterruptedException {

        User user = new User();
        user.setId(1);
        user.setName("Ivan Butenko");
        user.setUserName("Ivan");
        user.setEmail("butenkoivan898@gmail.com");
        user.setAddress("Street", "suite", "Kyiv", "00000", "50.420797", "30°31'44.1");
        user.setPhone("00-123456789");
        user.setWebsite("butenko");
        user.setCompany("nameCompany", "catchPhrase", "bs");

        User user1 = HttpUtil.createUser(URI.create(URI_USERS), user);

        System.out.println("\n----------\n");
        System.out.println(user1);

        System.out.println("\n----------\n");
        user1.setName("Tom");
        User user2 = HttpUtil.updateUser(URI.create(URI_USERS), user1);
        System.out.println(user2);

        System.out.println("\n----------\n");
        System.out.println(HttpUtil.deleteUser(URI.create(URI_USERS), user2));

        System.out.println("\n----------\n");
        System.out.println(HttpUtil.getAllUsers(URI.create(URI_USERS)).toString());

        System.out.println("\n----------\n");
        User user5 = HttpUtil.getUserWithId(URI.create(URI_USERS), 1);
        System.out.println(user5);

        System.out.println("\n----------\n");
        System.out.println(HttpUtil.getUserWithUsername(URI.create(URI_USERS), "Anna").toString());

        System.out.println("\n----------\n");
        HttpUtil.getAllCommentsWithLastPost(URI.create(URI_SITE));

        System.out.println("\n----------\n");
        HttpUtil.printAllUserTask(URI.create(URI_USERS));
    }
}
