package forum.lib;

import forum.model.User;

import java.time.LocalDate;

public class MyLib {


    public static void mostraMenuPpal() {

        System.out.println("Menú Ppal");
        System.out.println("0 - Sortir");
        System.out.println("1 - Register User");
        System.out.println("2 - LogIn");
    }


    public static void mostraMenuUsuari(User user) {

        System.out.println("Menú Usuari");
        System.out.println("0 - LogOut");
        System.out.println("1 - Seguir Nou usuari");
        System.out.println("2 - Esriure Post");
        System.out.println("3 - Eliminar Post");
        System.out.println("4 - Canviar password");
        System.out.println("5 - Veure Mur");



        if(user.getClass().getSimpleName().equalsIgnoreCase("admin")){
            System.out.println("6 - Eliminar usuari");
        }





    }

    public static void showAllUsers(User[] llistaUsers, int comptadorDeUsers, int fila) {

        for(int i=0; i<comptadorDeUsers; i++){
            if(!llistaUsers[fila].checkUserInFollowedList(llistaUsers[i])){
                System.out.println("Id: "+(i+1) +" - "+llistaUsers[i].mostraUserName());
            }
        }
    }
}
