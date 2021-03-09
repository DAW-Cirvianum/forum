package forum.model;

import java.time.LocalDate;

public class User {

    protected String userName, pass;
    protected User[] followedList = new User[100];
    protected int numberUsersFollowed;

    public User(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
        this.numberUsersFollowed = 0;

    }

    public void addUserToFollowedList(User u){
        this.followedList[numberUsersFollowed] = u;
        numberUsersFollowed++;
    }

    public void setSuperUser(boolean superUser) {
        System.out.println("Method not allowed");
    }


    public void setOlder18(String dataNaix) {
        System.out.println("Method not allowed.");
    }

    public void setejaOlder18(boolean b){
        System.out.println("Method not allowed.");
    }

    public int checkCred(User[] llistaUsers, int comptadorDeUsers) {
        for(int i=0; i<comptadorDeUsers; i++){
            if(llistaUsers[i].userName.equalsIgnoreCase(this.userName)){
                if(llistaUsers[i].pass.equals(this.pass)){
                    return i;
                }
            }
        }

        return -1;
    }


    public String mostraUserName() {
        return this.userName;
    }

    public boolean checkUserInFollowedList(User user){



        for(int i=0; i<this.numberUsersFollowed; i++){
            if(user.equals(this.followedList[i])){
                return true;
            }
        }

        return false;
    }

    public void addUserToList(User u){
        this.followedList[numberUsersFollowed] = u;
        this.numberUsersFollowed++;
    }

    public void mostraUsuarisSeguits(){
        for(int i=0; i<numberUsersFollowed; i++){
            System.out.println(this.followedList[i].userName);
        }
    }

    public void addFirstFollowed() {
        this.followedList[numberUsersFollowed] = this;
        this.numberUsersFollowed++;
    }
}
