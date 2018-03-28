import java.io.PrintStream;

public class CInvoiceLine extends CElement {
	public CProduct m_Product;
	public int m_Quantity;
	public CInvoiceLine(CProduct product, int quantity) {
		m_Product=product;
		m_Quantity=quantity;
	}
	public void Print(PrintStream out) {
		out.print("CInvoiceLine(");
		out.print(m_Product.m_Name);
		out.print(",");
		out.print(m_Quantity);
		out.print(")");
	}
	public float Factura(PrintStream out, float total) {
		return total + m_Product.m_Price * m_Quantity;
	}
	public void printFact(PrintStream out,int number) {
		out.print(m_Quantity + "               ");
		out.print(m_Product.m_Name + "          ");
		out.print(m_Product.m_Price + "               ");
		out.print(m_Product.m_Price * m_Quantity);
		out.println();
		
	}
}
