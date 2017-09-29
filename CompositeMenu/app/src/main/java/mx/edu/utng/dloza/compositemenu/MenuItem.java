package mx.edu.utng.dloza.compositemenu;

/**
 * Created by Daniel on 20/09/2017.
 */

public class MenuItem extends MenuComponent{
    private String name;
    private String description;
    private boolean vegetarian; //indica si es un elemento vegetariano
    private double price;

    public MenuItem(String name, String description, boolean vegetarian, double price){
        this.name= name;
        this.description= description;
        this.vegetarian=vegetarian;
        this.price=price;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public boolean isVegetarian(){
        return vegetarian;
    }

    public double getPrice(){
        return price;
    }

    public String print(){
        String v;
        if (isVegetarian()){
            v="vegetariana";
        }else{
            v="carnivoro";
        }
        return getName()+"\n"+getDescription()+"\n"+getPrice()+"\n"+v+"\n\n";
    }
}
