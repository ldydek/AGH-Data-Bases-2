namespace ŁukaszDydekEFProducts
{
    class Program
    {
        static void Main()
        {
            int invoiceID = 1;
            ProductContext productContext = new();

            var productsNames = (
                from pi in productContext.ProductInvoice
                join p in productContext.Products on pi.ProductID equals p.ProductID
                where pi.InvoiceNumber == invoiceID
                select p.ProductName
            ).ToList();

            foreach (var productName in productsNames)
            {
                Console.WriteLine(productName);
            }

            productContext.SaveChanges();
        }
    }
}
