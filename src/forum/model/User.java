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

    public boolean checkIfUserIsFollowed(User user){
        for(int i=0; i<this.numberUsersFollowed; i++){
            if(this.followedList[i].equals(user)){
                return true;
            }
        }
        return false;
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
            System.out.println((i+1)+" - "+this.followedList[i].userName);
        }
    }



    public void addFirstFollowed() {
        this.followedList[numberUsersFollowed] = this;
        this.numberUsersFollowed++;
    }

    public void mostraMenuUsuari() {

        System.out.println("Menú Usuari");
        System.out.println("0 - LogOut");
        System.out.println("1 - Follow");
        System.out.println("2 - UnFollow");
        System.out.println("3 - Mostrar Usuaris seguits");
        System.out.println("4 - Esriure Post");
        System.out.println("5 - Eliminar Post");
        System.out.println("6 - Veure Mur");
        System.out.println("7 - Canviar password");




        if(this.getClass().getSimpleName().equalsIgnoreCase("admin")){
            System.out.println("8 - Eliminar usuari");
        }





    }

    public void eliminaUsuariLlista(int posicio) {

        if(!this.userName.equalsIgnoreCase(this.followedList[posicio].userName)){
            for(int i = posicio ; i<this.numberUsersFollowed; i++){
                this.followedList[i] = this.followedList[i+1];
            }
            this.followedList[this.numberUsersFollowed] = null;

            this.numberUsersFollowed--;
        }else{
            System.out.println("Capoll! no pots fer-te un unfollow a tu mateix");
        }


    }

    public String getUserName() {
        return userName;
    }

    public boolean isOlder18() {
        System.out.println("Method not allowed");
        return false;
    }

    public boolean changePassword(String oldPass, String newPass){

        if(oldPass.equals(this.pass)){
            this.pass = newPass;
            return true;
        }else{
            return false;
        }


    }
}
