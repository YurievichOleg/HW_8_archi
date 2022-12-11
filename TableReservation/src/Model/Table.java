package Model;

public class Table {
    int number;
    int amount;
    int category;
    public Table(int number, int count, int category){
        this.number =number;
        this.amount = count;
        this.category = category;
    }
    public Table(){
        this(0,0,0);
    }
    public int getNumber(){
        return number;
    }
    public int getAmount(){
        return amount;
    }
    public  int getCategory(){
        return category;
    }

    @Override
    public String toString() {
        return "номер:" + number + " число мест:" + amount + " категория:" + category;
    }
}
