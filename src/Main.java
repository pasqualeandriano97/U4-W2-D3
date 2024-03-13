import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
      List<Product> products = new ArrayList<>();
      List<Product> products1 = new ArrayList<>();
      products.add(new Product("Book", "Books", 1100));
        products.add(new Product("Boy1", "Boys", 1100));
        products.add(new Product("Book1", "Books", 1100));
        products.add(new Product("Boy1", "Boys", 1100));
        products.add(new Product("Baby2", "Baby", 1100));
        products.add(new Product("Book5", "Books", 1100));
        products.add(new Product("Boy5", "Boys", 1100));
        products.add(new Product("Baby8", "Baby", 110));
        products1.add(new Product("Book5", "Books", 1100));
        products1.add(new Product("Boy5", "Boys", 1100));
        products1.add(new Product("Baby8", "Baby", 110));
        System.out.println("Prodotti di categoria Books con prezzo minore di 100: "+products.stream().filter(p -> p.getCategory().equals("Books")&&(p.getPrice()>100)).toList());
        List<Product> filteredProducts= products.stream().filter(p -> p.getCategory().equals("Boys")).toList();
        Customer customer = new Customer("John", 1);
        Customer customer1 = new Customer("Jane", 2);
        Customer customer2 = new Customer("Maria", 3);
        LocalDate date = LocalDate.of(2021, 2, 10);
        LocalDate date1 = LocalDate.of(2021, 2, 15);
        LocalDate date2 = LocalDate.of(2021, 1, 15);
        Order order = new Order("In elaborazione",date,products,customer);
        Order order1 = new Order("Spedito",date1,filteredProducts,customer1);
        Order order2 = new Order("Consegnato",date2,products1,customer2);
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        orders.add(order1);
        orders.add(order2);
        System.out.println("Ordini totali"+orders);
        List<Order> filteredOrders=orders.stream().filter(o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equals("Baby"))).toList();
        System.out.println("Ordini con prodotti di categoria Baby: "+filteredOrders);
      filteredProducts.stream().forEach(p -> p.setPrice(p.getPrice()*0.9));
      System.out.println("Prodotti con categoria Boys e sconto del 10% : "+filteredProducts);

        System.out.println("Ordini totali"+orders);
       orders.stream().forEach(o -> o.getProducts().forEach(product -> System.out.println(product.sameCategoryB(o.getProducts()))));

        for(Order o:orders) {
            if (o.getCustomer().getTier().equals(2)&&o.getOrderDate().isAfter(LocalDate.of(2021, 2, 1))&&o.getOrderDate().isBefore(LocalDate.of(2021, 4, 1))) {
                System.out.println("Prodotti ordinati da client1 con livello 2 e date comprese tra 01/02/2021 e 01/04/2021: ");
                for (Product product : o.getProducts()) {
                    System.out.println(product);
                }
            }
        }
    }
}