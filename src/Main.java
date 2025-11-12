

public class Main
{
    public static void main(String[] args)
    {
	
        Customer c1 = new Customer(2, "Juancho", "Monterey", 24, "juan@gmail.com",2);
        Customer c2 = new Customer(3, "Lola", "Perez", 25, "lola@example.com",1);
        MySqlCRUD conn = new MySqlCRUD();
	
        System.out.println("La conexión está lista para ser usada.");

        System.out.println("\n===== insertar cliente =====");
        conn.insertCustomer(c1);
        conn.insertCustomer(c2);

        System.out.println("\n===== leer clientes =====");
        conn.readCustomer();

        System.out.println("\n===== actualizar cliente =====");
        conn.updateCustomer(1, "Leonardo");
        conn.updateCustomer(5, "Carlos");

	
        System.out.println("\n===== actualizar suscripcion de cliente =====");
        conn.updateCustomerSuscription(1, 1);
        conn.updateCustomerSuscription(5, 1);

	//        System.out.println("\n===== eliminar cliente =====");
        //conn.deleteCustomer(1);
        //conn.deleteCustomer(5);


	MongoCRUD mongoCRUD = new MOngoCRUD();
	
	System.out.println("La conexión a MongoDB esta lista para ser usada.");
	
        System.out.println("\n===== MongoDB insertar cliente =====");
        mongoCRUD.insertCustomer(c1);
        mongoCRUD.insertCustomer(c2);

        System.out.println("\n===== MongoDB leer clientes =====");
        mongoCRUD.readCustomer();

        System.out.println("\n===== MongoDB actualizar cliente =====");
        mongoCRUD.updateCustomer(1, "Leonardo");
        mongoCRUD.updateCustomer(5, "Carlos");

	
        System.out.println("\n===== actualizar suscripcion de cliente =====");
        mongoCRUD.updateCustomerSuscription(1, 1);
        mongoCRUD.updateCustomerSuscription(5, 1);

	//        System.out.println("\n===== MongoDB eliminar cliente =====");
        //mongoCRUD.deleteCustomer(1);
        //mongioCRUD.deleteCustomer(5);

        
    }
}
