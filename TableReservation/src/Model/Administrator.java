package Model;

public class Administrator {
    String name;
    int workingShift;
    public  Administrator(String name, int workingShift){
        this.name = name;
        this.workingShift = workingShift;
    }
    public String getName(){
        return name;
    }
    public int getWorkingShift(){
        return workingShift;
    }
}
