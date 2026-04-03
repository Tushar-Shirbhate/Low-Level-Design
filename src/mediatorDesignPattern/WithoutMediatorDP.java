package mediatorDesignPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class UserWMDP{
    private String name;
    private List<UserWMDP> users;

    public UserWMDP(String name){
        this.name = name;
        this.users = new ArrayList<>();
    }

    public void addUsers(List<UserWMDP> users){
        this.users = users;
    }

    public void sendMessage(String message){
        for(UserWMDP user : users){
            if(user != this){
                user.receiveMessage(this, message);
            }
        }
    }

    public void receiveMessage(UserWMDP sender, String message){
        System.out.println(name + " received message from " + sender.name + ": " + message);
    }

}
public class WithoutMediatorDP {
    public static void main(String[] args){
        UserWMDP user1 = new UserWMDP("A");
        UserWMDP user2 = new UserWMDP("B");
        UserWMDP user3 = new UserWMDP("C");

        List<UserWMDP> allUsers = Arrays.asList(user1,user2,user3);

        user1.addUsers(allUsers);
        user2.addUsers(allUsers);
        user3.addUsers(allUsers);

        user1.sendMessage("Hello Everyone");
    }
}
