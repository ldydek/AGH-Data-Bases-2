namespace ŁukaszDydekEFProducts
{
    internal class Supplier
    {
        public int SupplierID { get; set; }
        public string CompanyName { get; set; }
        public string Street { get; set; }
        public string City { get; set; }
        public List<Product> Products { get; set; } = new();

        public Supplier(string CompanyName, string Street, string City) 
        { 
            this.CompanyName = CompanyName;
            this.Street = Street;
            this.City = City;
        }

        public void AddProducts(List<Product> products)
        {
            Products.AddRange(products);
        }
    }
}
