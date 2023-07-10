using ŁukaszDydekEFProducts;

class Program
{
    static void Main()
    {
        ProductContext productContext = new();
        Product product1 = new("Golarka", 13);
        Product product2 = new("Szampon", 15);
        Product product3 = new("Mydło", 34);
        Product product4 = new("Szczoteczka", 18);
 
        productContext.Products.Add(product1);
        productContext.Products.Add(product2);
        productContext.Products.Add(product3);
        productContext.Products.Add(product4);

        Invoice invoice1 = new();
        Invoice invoice2 = new();

        productContext.Invoices.Add(invoice1);
        productContext.Invoices.Add(invoice2);

        product1.Sell(invoice1, 10);
        product2.Sell(invoice2, 4);
        product3.Sell(invoice2, 5);
        product4.Sell(invoice1, 6);

        productContext.SaveChanges();
    }
}
