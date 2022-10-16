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

    private ArrayList<ItemCart> items = new ArrayList<>();

    public Cart() {
    }

    public Cart(ArrayList<ItemCart> items) {
        this.items = new ArrayList<>();
    }

    public void setItems(ArrayList<ItemCart> items) {
        this.items = items;
    }

    public int getQuantityById(int id) {
        return getItemById(id).getQuantity();
    }

    public ItemCart getItemById(int id) {
        for (ItemCart i : items) {
            if (i.getProduct().getId() == id) {
                return i;
            }
        }
        return null;
    }

    public void addItem(ItemCart t) {
        if (getItemById(t.getProduct().getId()) != null) {
            ItemCart i = getItemById(t.getProduct().getId());
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
        for (ItemCart item : items) {
            t += (item.getQuantity() * item.getProduct().getPrice());
        }
        return t;
    }

    public ArrayList<ItemCart> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Cart{" + "items=" + items + '}';
    }

}
