using ŁukaszDydekEFProducts;


class Program
{
    static void Main()
    {
        ProductContext productContext = new();

        var result1 = productContext.Suppliers.FirstOrDefault(s => s.CompanyID == 1);
        var result2 = productContext.Customers.FirstOrDefault(c => c.CompanyID == 3);

        Console.WriteLine(result1.CompanyID);
        Console.WriteLine(result1.BankAccountNumber);
        Console.WriteLine(result1.City);
        Console.WriteLine(result1.CompanyName);
        Console.WriteLine();
        Console.WriteLine(result2.CompanyID);
        Console.WriteLine(result2.Discount);
        Console.WriteLine(result2.City);
        Console.WriteLine(result2.CompanyName);
        Console.ReadKey();

        productContext.SaveChanges();
    }
}
