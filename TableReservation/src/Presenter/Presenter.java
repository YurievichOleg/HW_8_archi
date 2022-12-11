package Presenter;

import Model.Repository;


public class Presenter implements ChangeTableOrder, MakeReservation, ShowTables{
    Repository repository = new Repository();

    @Override
    public boolean changeTableOrder(int date, int tableNumber) {
        boolean res = false;
        if(repository.orderExistence(date, tableNumber)){
            repository.changeTable(date, tableNumber);
            res = true;
            System.out.println("Order is delete");
        }else {
            System.out.println("There is no such order");
        }
        return res;
    }

    @Override
    public boolean makeReservation(int date, int tableNumber) {
        boolean res = false;
        if(repository.tablesExist(tableNumber) && !repository.orderExistence(date, tableNumber)){
            repository.bookTable(date, tableNumber);
            System.out.println("The table is booked");
            res = true;
        }else {
            System.out.println("The table is already booked");
        }
        return res;
    }

    @Override
    public String showTables(int date) {
        String res = "";
        for(int i = 0; i < repository.loadTables(date).size(); i ++){
            res = res + repository.loadTables(date).get(i).toString() + "\n";
        }
        return res;
    }
}
