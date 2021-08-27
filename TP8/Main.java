package TP8;

public class Main {
    public static void main(String[] args) throws Exception {
        ConnectionDB connection = new ConnectionDB();
        connection.openConnection();
        Crud crud = new Crud(connection.getConnection());
        
        crud.create("Luis", 6);
        crud.create("Miguel", 7);
        crud.create("Andressa", 8);
        crud.create("Monica", 9);
        crud.create("Juliana", 10);
        
        /*crud.read(6);
        crud.read(7);
        crud.read(8);
        crud.read(9);
        crud.read(10);*/
        
        crud.delete(7);
        crud.delete(8);
        
        connection.closeConnection();
    }
}