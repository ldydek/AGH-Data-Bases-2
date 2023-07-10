using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace ŁukaszDydekEFProducts
{
    internal class ProductInvoice
    {
        [Key]
        [Column(Order = 1)]
        [ForeignKey("Invoice")]
        public int InvoiceNumber { get; set; }

        [Key]
        [Column(Order = 2)]
        [ForeignKey("Product")]
        public int ProductID { get; set; }
        public int Quantity { get; set; }

        public virtual Invoice Invoice { get; set; }
        public virtual Product Product { get; set; }
    }
}
