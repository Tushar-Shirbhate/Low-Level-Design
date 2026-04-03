package mediatorDesignPattern;

import java.util.ArrayList;
import java.util.List;

interface ChatMediator{
    void registerUser(UserMDP user);
    void sendMessage(UserMDP sender, String message);
}

class ChatRoom implements ChatMediator{
    private List<UserMDP> users;

    public ChatRoom(){
        this.users = new ArrayList<>();
    }

    @Override
    public void registerUser(UserMDP user){
        users.add(user);
    }

    @Override
    public void sendMessage(UserMDP sender, String message){
        for(UserMDP user : users){
            if(user != sender){
                user.receiveMessage(sender, message);
            }
        }
    }
}

class UserMDP{
    private String name;
    private ChatMediator chatMediator;

    public UserMDP(String name, ChatMediator chatMediator){
        this.name = name;
        this.chatMediator = chatMediator;
    }

    public void sendMessage(String message){
        chatMediator.sendMessage(this, message);
    }

    public void receiveMessage(UserMDP sender, String message){
        System.out.println(name + " received message from " + sender.name + ": " + message);
    }
}

public class MediatorDP {
    public static void main(String[] args){
        ChatMediator chatRoom = new ChatRoom();
        UserMDP user1 = new UserMDP("A", chatRoom);
        UserMDP user2 = new UserMDP("B", chatRoom);
        UserMDP user3 = new UserMDP("C", chatRoom);

        chatRoom.registerUser(user1);
        chatRoom.registerUser(user2);
        chatRoom.registerUser(user3);

        user1.sendMessage("Hello Everyone");
    }
}
