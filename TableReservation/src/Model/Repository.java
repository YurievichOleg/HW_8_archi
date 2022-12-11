package Model;

import javax.imageio.IIOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Repository implements loadTables, BookTable, ChangeTable{
        @Override
        public void bookTable(int date, int tableNumber) {
            try {
                OrdersStorage.makeOrder(date, tableNumber);
                System.out.println("Order is Ok");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (IIOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public ArrayList<Table> loadTables(int date) {
            ArrayList<Integer> freeTables;
            ArrayList <Table> tablesForShow = new ArrayList<>();
            try {
                ResultSet resultSet = OrdersStorage.loadTables(date);
                freeTables = new ArrayList<>();

                while (resultSet.next()){
                    freeTables.add(resultSet.getInt(1));
                }
                for(int i = 0; i < freeTables.size(); i++){
                    tablesForShow.add(TableStorage.getTable(freeTables.get(i)));
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (IIOException e) {
                throw new RuntimeException(e);
            }
            return tablesForShow;
        }

        @Override
        public void changeTable(int dateOrder, int tableId) {
            try {
                OrdersStorage.changeTable(dateOrder,tableId);
                System.out.println("Order is changed");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (IIOException e) {
                throw new RuntimeException(e);
            }
        }
        public boolean tablesExist(int num) {
            boolean res = false;
            try {
                res = TableStorage.tableExist(num);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (IIOException e) {
                throw new RuntimeException(e);
            }
            return res;
        }

        public boolean orderExistence(int date, int tableNumber){
            boolean res = false;
            try {
                res = OrdersStorage.orderExist(date, tableNumber);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (IIOException e) {
                throw new RuntimeException(e);
            }
            return res;
        }
    }
