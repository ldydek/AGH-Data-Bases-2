namespace ŁukaszDydekEFProducts
{
    class Program
    {
        static void Main()
        {
            ProductContext productContext = new();
            int productID = 4;
            Supplier supplier = new("DPD", "Lawendowa", "Kraków");
            productContext.Suppliers.Add(supplier);

            var query = from prod in productContext.Products
                        where prod.ProductID == productID
                        select prod;
            var product = query.FirstOrDefault();

            product.Supplier = supplier;
            productContext.SaveChanges();
        }
    }
}
