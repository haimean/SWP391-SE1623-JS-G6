/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author PiPi
 */
public class Cart {

    private ArrayList<Item> items = new ArrayList<>();

    public Cart() {
    }

    public Cart(ArrayList<Item> items) {
        this.items = new ArrayList<>();
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public int getQuantityById(int id) {
        return getItemById(id).getQuantity();
    }

    public Item getItemById(int id) {
        for (Item i : items) {
            if (i.getProduct().getId() == id) {
                return i;
            }
        }
        return null;
    }

    public void addItem(Item t) {
        if (getItemById(t.getProduct().getId()) != null) {
            Item i = getItemById(t.getProduct().getId());
            i.setQuantity(i.getQuantity() + t.getQuantity());
        } else {
            items.add(t);
        }
    }

    public void removeItem(int id) {
        if (getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }
    
    public void removeAllItems(){
        items.removeAll(items);
    }

    public double getTotalMoney() {
        double t = 0;
        for (Item item : items) {
            t += (item.getQuantity() * item.getProduct().getPrice());
        }
        return t;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Cart{" + "items=" + items + '}';
    }

}
