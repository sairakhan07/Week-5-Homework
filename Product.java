import java.util.ArrayList;

public class Product 
{
    private int id;
    private String name;
    private int quantity;

    public Product(int id, String name, int quantity) 
    {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public int getQuantity() 
    {
        return quantity;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setQuantity(int quantity) 
    {
        this.quantity = quantity;
    }

    public void print() 
    {
        System.out.println("ID: " + id + "; Name: " + name + "; Quantity: " + quantity);
    }
}

class StockList 
{
    private ArrayList<Product> productList;

    public StockList() 
    {
        productList = new ArrayList<>();
    }

    public void addProduct(Product item) 
    {
        productList.add(item);
    }

    public void removeProduct(Product item) 
    {
        productList.remove(item);
    }

    public Product findItem(String name) 
    {

        for (Product item : productList) 
        {

            if (item.getName().equals(name)) 
            {
                return item;
            }

        }

        return null;
    }

    public void printProducts() 
    {

        for (Product item : productList) 
        {
            item.print();
        }

    }
}

class StockDemo 
{
    private StockList stockList = new StockList();

    public void testAddProducts() 
    {

        Product p1 = new Product(1, "Laptop", 5);
        Product p2 = new Product(2, "Mouse", 10);
        Product p3 = new Product(3, "Keyboard", 7);

        stockList.addProduct(p1);
        stockList.addProduct(p2);
        stockList.addProduct(p3);

        System.out.println("Products added.");
    }

    public void testPrintProducts() 
    {

        System.out.println("Current Stock:");
        stockList.printProducts();
    }

    public void testFindProduct() 
    {

        System.out.println("Searching for Laptop...");

        Product product = stockList.findItem("Laptop");

        if (product != null) 
        {
            System.out.println("Product found:");
            product.print();
        } else 
        {
            System.out.println("Product not found.");
        }

    }

    public void testRemoveProduct() 
    {

        System.out.println("Removing Mouse...");

        Product item = stockList.findItem("Mouse");

        if (item != null) 
        {
            stockList.removeProduct(item);
        }

    }

    public void run() 
    {

        testAddProducts();
        testPrintProducts();
        testFindProduct();
        testRemoveProduct();

        System.out.println("Stock after removal:");
        testPrintProducts();

    }

    public static void main(String[] args) 
    {

        StockDemo demo = new StockDemo();
        demo.run();

    }
}