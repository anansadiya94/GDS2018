import java.io.PrintStream;

public class CInvoice extends CElement {
	public int m_Number;
	public CClient m_Client;
	public CInvoiceLineList m_Lines;
	public CInvoice(int number,CClient client) {
		m_Number=number;
		m_Client=client;
		m_Lines=new CInvoiceLineList();
	}
	public void AddProduct(CInvoiceLine invoiceLine) {
		m_Lines.PushBack(invoiceLine);
	}
	public void DeleteProduct(CInvoiceLine invoiceLine) {
		m_Lines.Delete(invoiceLine);
	}
	public void Print(PrintStream out) {
		out.print("Invoice(");
		out.print(m_Number);
		out.print(",");
		out.print(m_Client.m_Name);
		out.print(",");
		m_Lines.Print(out);
		out.print(")");
	}
	public float Factura(PrintStream out, float total) {
		out.print(m_Number + "                   ");
		out.print(m_Client.m_Name + "                ");
		total = m_Lines.Factura(out, total);
		return total;
	}
}
