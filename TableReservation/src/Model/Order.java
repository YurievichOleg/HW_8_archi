package Model;

public class Order {
    int date;
    int tableId;
    public Order(int date, int tableId){
        this.date = date;
        this.tableId = tableId;
    }
    public int getDate(){
        return date;
    }

    public int getTableId(){
        return tableId;
    }
}
