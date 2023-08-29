using ŁukaszDydekEFProducts;


class Program
{
    static void Main()
    {
        ProductContext productContext = new();

        Supplier supplier = new Supplier
        {
            CompanyName = "ABC Suppliers",
            Street = "123 Supplier St",
            City = "Supplier City",
            ZipCode = "12345",
            BankAccountNumber = "1234567890"
        };

        productContext.Companies.Add(supplier);

        Customer customer = new Customer
        {
            CompanyName = "XYZ Customers",
            Street = "456 Customer Ave",
            City = "Customer City",
            ZipCode = "54321",
            Discount = 15
        };

        productContext.Companies.Add(customer);

        productContext.SaveChanges();
    }
}

