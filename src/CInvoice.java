import java.io.PrintStream;

public class CInvoice extends CElement {
	public int m_Number;
	public CClient m_Client;
	public CProductList m_Products;
	public CInvoice(int number,CClient client) {
		m_Number=number;
		m_Client=client;
		m_Products=new CProductList();
	}
	public void AddProduct(CProduct product) {
		m_Products.PushBack(product);
	}
	public void DeleteProduct(CProduct product) {
		m_Products.Delete(product);
	}
	public void Print(PrintStream out) {
		out.print("Invoice(");
		out.print(m_Number);
		out.print(",");
		out.print(m_Client.m_Name);
		out.print(",");
		m_Products.Print(out);
		out.print(")");
	}
}
