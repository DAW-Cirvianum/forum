package forum.lib;

import forum.model.Post;
import forum.model.User;

import java.time.LocalDate;

public class MyLib {


    public static void mostraMenuPpal() {

        System.out.println("Menú Ppal");
        System.out.println("0 - Sortir");
        System.out.println("1 - Register User");
        System.out.println("2 - LogIn");
    }


    public static void showAllUsers(User[] llistaUsers, int comptadorDeUsers, int fila) {

        for (int i = 0; i < comptadorDeUsers; i++) {
            if (!llistaUsers[fila].checkUserInFollowedList(llistaUsers[i])) {
                System.out.println("Id: " + (i + 1) + " - " + llistaUsers[i].mostraUserName());
            }
        }
    }

    public static void mostraElsMeusPosts(Post[] llistaPosts, int comptadorDePosts, User user) {
        for (int i = 0; i < comptadorDePosts; i++) {
            if (llistaPosts[i].getAuthor().equals(user)) {
                System.out.println("Id: " + (i + 1) + " - " + llistaPosts[i].getSubject());
            }

        }
    }

    public static void removeAndOrderArray(Object[] array, int comptador, int posicioAEsborrar) {
        for (int i = posicioAEsborrar; i < comptador; i++) {
            array[i] = array[i + 1];
        }
        array[comptador] = null;
    }

    public static void mostraElMeuMur(Post[] llistaPosts, int comptadorDePosts, User user) {

        for (int i = 0; i < comptadorDePosts; i++) {
            boolean mostra = false;
            if (user.checkIfUserIsFollowed(llistaPosts[i].getAuthor())) {
                if(!llistaPosts[i].isOlder18()){
                    mostra=true;
                }else if(llistaPosts[i].isOlder18() && user.isOlder18()){
                    mostra=true;
                }
            }
            if(mostra){
                System.out.println("****************************");
                System.out.println("Id Post: " + (i + 1));
                System.out.println("Subject: " + llistaPosts[i].getSubject());
                System.out.println("Body: " + llistaPosts[i].getBody());
                System.out.println("Author: "+llistaPosts[i].getAuthor().getUserName());
                System.out.println("Created at: " + llistaPosts[i].getLdtWrited().toString());
            }
        }




    }
}
