package View;

import Presenter.Presenter;

import java.util.Scanner;

public class View {
    Scanner scanner;
    Presenter presenter ;
    public View(){
        scanner = new Scanner(System.in);
        presenter = new Presenter();

    }
    public void run(){
        System.out.println("Введите 1 для просмотра свободных столов\n" +
                "Введите 2 для бронирования столика\n" +
                "Введите 3 для изменения бронирования\n" +
                "Введите 0 для выхода");
        int a = Integer.parseInt(scanner.nextLine());
        if(a == 3){
            int date; int tableNumber;
            System.out.println("Введите дату");
            date = Integer.parseInt(scanner.nextLine());
            System.out.println("Введите номер стола");
            tableNumber = Integer.parseInt(scanner.nextLine());
            presenter.changeTableOrder(date, tableNumber);
            this.run();
        } else if (a == 1) {
            int date;
            System.out.println("Введите дату для просмотра свободных столов");
            date = Integer.parseInt(scanner.nextLine());
            System.out.println(presenter.showTables(date));
            this.run();
        } else if (a == 2) {
            int date; int tableNumber;
            System.out.println("Введите дату");
            date = Integer.parseInt(scanner.nextLine());
            System.out.println("Введите номер стола");
            tableNumber = Integer.parseInt(scanner.nextLine());
            presenter.makeReservation(date, tableNumber);
            this.run();
        } else if (a == 0){
            scanner.close();

        }else{
            System.out.println("Введены  некорректные данные.");
            this.run();
        }
    }

}
