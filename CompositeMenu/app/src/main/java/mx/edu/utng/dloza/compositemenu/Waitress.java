package mx.edu.utng.dloza.compositemenu;

/**
 * Created by Daniel on 20/09/2017.
 */

public class Waitress {//Camarero
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus){
        this.allMenus= allMenus;
    }

    public String printMenu(){
        return allMenus.print();
    }
}
