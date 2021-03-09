package forum;

import forum.lib.MyLib;
import forum.model.Admin;
import forum.model.Client;
import forum.model.Post;
import forum.model.User;

import java.util.Scanner;

public class Forum {

    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);

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


        boolean buclePpal = true;

        while(buclePpal){

            MyLib.mostraMenuPpal();
            System.out.print("Opció: ");
            int opcio = sc.nextInt();
            sc.nextLine();
            switch (opcio){
                case 0:
                    buclePpal = false;
                    System.out.println("Vagi bé!");
                    break;

                case 1:
                    System.out.print("User: ");
                    String userIn = sc.nextLine();
                    System.out.print("Password: ");
                    String passIn = sc.nextLine();
                    llistaUsers[comptadorDeUsers] = new Client(userIn,passIn);
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

                    User userTmp = new User(userLogIn,passLogIn);
                    int fila = userTmp.checkCred(llistaUsers,comptadorDeUsers);
                    if(fila>-1){
                        boolean bucleMenuUser = true;
                        while (bucleMenuUser){

                            MyLib.mostraMenuUsuari(llistaUsers[fila]);
                            System.out.print("Opció: ");
                            opcio = sc.nextInt();
                            sc.nextLine();

                            switch (opcio){
                                case 0:
                                    bucleMenuUser = false;
                                    break;

                                case 1:
                                    MyLib.showAllUsers(llistaUsers,comptadorDeUsers,fila);
                                    opcio = sc.nextInt();
                                    sc.nextLine();
                                    llistaUsers[fila].addUserToList(llistaUsers[opcio-1]);
                                    //llistaUsers[fila].mostraUsuarisSeguits();
                                    break;

                                case 2:

                                    break;
                            }

                        }


                    }else{
                        System.out.println("Invalid Credentials");
                    }

                    break;



            }


        }
    }




}
