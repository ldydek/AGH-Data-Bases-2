using ŁukaszDydekEFProducts;

class Program
{
    static void Main()
    {
        int productID = 3;
        ProductContext productContext = new();

        var invoices = (
                from pi in productContext.ProductInvoice
                where pi.ProductID == productID
                select pi
                ).ToList();
        
        foreach (var invoice in invoices )
        {
            Console.WriteLine(invoice.InvoiceNumber);
        }

        productContext.SaveChanges();
    }
}
