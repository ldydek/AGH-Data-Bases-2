namespace ŁukaszDydekEFProducts
{
    class Program
    {
        static void Main()
        {
            int supplierID = 1;
            ProductContext productContext = new();
            Product product1 = new("Komoda", 10);
            Product product2 = new("Woda", 5);
            Product product3 = new("Elektrolity", 3);
            Product product4 = new("Proszek Fiuu", 100);

            productContext.Products.Add(product1);
            productContext.Products.Add(product2);
            productContext.Products.Add(product3);
            productContext.Products.Add(product4);

            List<Product> products = new()
            {
                product1,
                product2,
                product3,
                product4
            };

            var query = from sup in productContext.Suppliers
                        where sup.SupplierID == supplierID
                        select sup;
            var supplier = query.FirstOrDefault();
            supplier.AddProducts(products);
            productContext.SaveChanges();
        }
    }
}
