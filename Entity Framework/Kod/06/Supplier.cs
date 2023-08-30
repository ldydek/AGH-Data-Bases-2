using System.ComponentModel.DataAnnotations.Schema;

namespace ŁukaszDydekEFProducts
{
    [Table("Suppliers")]
    internal class Supplier : Company
    {
        public string BankAccountNumber { get; set; }
    }
}
