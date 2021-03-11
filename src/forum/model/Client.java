package forum.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Client extends User{

    private boolean isOlder18;

    public Client(String userName, String pass) {
        super(userName, pass);
        this.isOlder18 = false;
    }

    @Override
    public void setOlder18(String dataNaix) {
        String[] array = dataNaix.split("/");
        int dia = Integer.parseInt(array[0]);
        int mes = Integer.parseInt(array[1]);
        int any = Integer.parseInt(array[2]);

        Period p = Period.between(LocalDate.of(any,mes,dia),LocalDate.now());

        if(p.getYears()>17){
            this.isOlder18=true;
        }
    }

    public void setejaOlder18(boolean b){
        this.isOlder18=b;
    }

    @Override
    public boolean isOlder18() {
        return this.isOlder18;
    }
}
