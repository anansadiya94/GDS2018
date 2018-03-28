import java.io.PrintStream;
import java.util.Calendar;


public class CInvoice extends CElement {
	public int m_Number;
	public CClient m_Client;
	public CInvoiceLineList m_Lines;
	//public Calendar m_date;
	public String m_date;
	public CInvoice(int number,String fecha,CClient client) {
		m_Number=number;
		m_Client=client;
		m_date = fecha;
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
		out.print(m_date);
		out.print(",");
		m_Lines.Print(out);
		out.print(")");
	}
	public float Factura(PrintStream out, float total) {
		out.print(m_Number + "                   ");
		out.print(m_date + "         ");
		out.print(m_Client.m_Name + "                ");
		total = m_Lines.Factura(out, total);
		return total;
	} 
	public void getNumber(PrintStream out) {
		out.print(m_Number);
		//return m_Number;
	}
	public void getDate(PrintStream out) {
		out.print(m_date);
	}
	public void getName(PrintStream out) {
		out.print(m_Client.m_Name);
	}
	public void printFact(PrintStream out, int number) {
			float total = 0;
			m_Lines.printFact(out);
			if (number == 0)
			total = m_Lines.Factura(out, total);
			//System.out.println();
	}		
}
	

