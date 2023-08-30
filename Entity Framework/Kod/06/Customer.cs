using System.ComponentModel.DataAnnotations.Schema;

namespace ŁukaszDydekEFProducts
{
    [Table("Customers")]
    internal class Customer : Company
    {
        public int Discount { get; set; }
    }
}
