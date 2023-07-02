namespace ŁukaszDydekEFProducts
{
    internal class Supplier
    {
        public int SupplierID { get; set; }
        public string CompanyName { get; set; }
        public string Street { get; set; }
        public string City { get; set; }

        public Supplier(string CompanyName, string Street, string City) 
        { 
            this.CompanyName = CompanyName;
            this.Street = Street;
            this.City = City;
        }
    }
}
