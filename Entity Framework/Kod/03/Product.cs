namespace ŁukaszDydekEFProducts
{
    internal class Product
    {
        public int ProductID { get; set; }
        public string ProductName { get; set; }
        public int UnitsOnStock { get; set; }

        public Product(string productName, int unitsOnStock) 
        {
            this.ProductName = productName;
            this.UnitsOnStock = unitsOnStock;
        }
    }
}
