using System.ComponentModel.DataAnnotations;

namespace ŁukaszDydekEFProducts
{
    internal class Invoice
    {
        [Key]
        public int InvoiceNumber { get; set; }
        public int Quantity { get; set; } = 0;
        public List<ProductInvoice> ProductInvoices { get; } = new();
        public void AddProduct(ProductInvoice productInvoice, int quantity)
        {
            ProductInvoices.Add(productInvoice);   
            this.Quantity += quantity;
        }
    }
}
