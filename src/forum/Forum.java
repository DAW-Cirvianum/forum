package forum;

import forum.lib.MyLib;
import forum.model.Admin;
import forum.model.Client;
import forum.model.Post;
import forum.model.User;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Forum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Post[] llistaPosts = new Post[1000];
        int comptadorDePosts = 0;

        User[] llistaUsers = new User[100];
        int comptadorDeUsers = 0;

/*        System.out.print("SuperUser: ");
        String superUser = sc.nextLine();
        System.out.print("Password: ");
        String passSuperUser = sc.nextLine();


        llistaUsers[comptadorDeUsers] = new Admin(superUser,passSuperUser);
        llistaUsers[comptadorDeUsers].setSuperUser(true);



 */
        llistaUsers[comptadorDeUsers] = new Admin("admin", "admin");
        llistaUsers[comptadorDeUsers].setSuperUser(true);
        llistaUsers[comptadorDeUsers].addFirstFollowed();
        comptadorDeUsers++;

        llistaUsers[comptadorDeUsers] = new Admin("hector", "1234");
        llistaUsers[comptadorDeUsers].addFirstFollowed();

        comptadorDeUsers++;

        llistaUsers[comptadorDeUsers] = new Client("pepe", "1234");
        llistaUsers[comptadorDeUsers].setejaOlder18(true);
        llistaUsers[comptadorDeUsers].addFirstFollowed();
        comptadorDeUsers++;

        llistaUsers[comptadorDeUsers] = new Client("izan", "1234");
        llistaUsers[comptadorDeUsers].setejaOlder18(false);
        llistaUsers[comptadorDeUsers].addFirstFollowed();
        comptadorDeUsers++;


        boolean buclePpal = true;

        while (buclePpal) {

            MyLib.mostraMenuPpal();
            System.out.print("Opció: ");
            int opcio = sc.nextInt();
            sc.nextLine();
            switch (opcio) {
                case 0:
                    buclePpal = false;
                    System.out.println("Vagi bé!");
                    break;

                case 1:
                    System.out.print("User: ");
                    String userIn = sc.nextLine();
                    System.out.print("Password: ");
                    String passIn = sc.nextLine();
                    llistaUsers[comptadorDeUsers] = new Client(userIn, passIn);
                    System.out.print("Data naixament (dd/mm/yyyy): ");
                    String dataNaix = sc.nextLine();
                    llistaUsers[comptadorDeUsers].setOlder18(dataNaix);
                    llistaUsers[comptadorDeUsers].addFirstFollowed();
                    comptadorDeUsers++;
                    break;

                case 2:
                    System.out.print("User: ");
                    String userLogIn = sc.nextLine();
                    System.out.print("Password: ");
                    String passLogIn = sc.nextLine();

                    User userTmp = new User(userLogIn, passLogIn);
                    int fila = userTmp.checkCred(llistaUsers, comptadorDeUsers);
                    if (fila > -1) {
                        boolean bucleMenuUser = true;
                        while (bucleMenuUser) {

                            llistaUsers[fila].mostraMenuUsuari();
                            System.out.print("Opció: ");
                            opcio = sc.nextInt();
                            sc.nextLine();

                            switch (opcio) {
                                case 0:
                                    bucleMenuUser = false;
                                    System.out.println("LogOut");
                                    break;

                                case 1:
                                    MyLib.showAllUsers(llistaUsers, comptadorDeUsers, fila);
                                    opcio = sc.nextInt();
                                    sc.nextLine();
                                    llistaUsers[fila].addUserToList(llistaUsers[opcio - 1]);

                                    break;

                                case 2:
                                    llistaUsers[fila].mostraUsuarisSeguits();
                                    System.out.print("Opció: ");
                                    opcio = sc.nextInt();
                                    sc.nextLine();
                                    llistaUsers[fila].eliminaUsuariLlista(opcio - 1);
                                    break;

                                case 3:
                                    llistaUsers[fila].mostraUsuarisSeguits();

                                    break;

                                case 4:
                                    System.out.print("Subject: ");
                                    String subject = sc.nextLine();
                                    System.out.println("Body: ");
                                    String body = sc.nextLine();
                                    System.out.println("Majors de 18? (S/N)");
                                    boolean older18;
                                    if (sc.nextLine().equalsIgnoreCase("s")) {
                                        older18 = true;
                                    } else {
                                        older18 = false;
                                    }

                                    llistaPosts[comptadorDePosts] = new Post(subject, body, LocalDateTime.now(), llistaUsers[fila],older18);
                                    comptadorDePosts++;

                                    break;

                                case 5:
                                    MyLib.mostraElsMeusPosts(llistaPosts, comptadorDePosts, llistaUsers[fila]);
                                    System.out.println("Opció: ");
                                    opcio = sc.nextInt();
                                    sc.nextLine();
                                    MyLib.removeAndOrderArray(llistaPosts, comptadorDePosts, (opcio + 1));
                                    comptadorDePosts--;
                                    break;

                                case 6:
                                    MyLib.mostraElMeuMur(llistaPosts,comptadorDePosts,llistaUsers[fila]);

                                    break;

                                case 7:
                                    System.out.println("Introdueix el passs antic");
                                    String oldPass = sc.nextLine();
                                    System.out.println("Introdueix el nou pass");
                                    String newPass = sc.nextLine();
                                    if(llistaUsers[fila].changePassword(oldPass, newPass)){
                                        System.out.println("Password modificat ok");
                                    }else{
                                        System.out.println("Error en les credecials.");
                                    }
                            }

                        }


                    } else {
                        System.out.println("Invalid Credentials");
                    }

                    break;


            }


        }
    }


}
