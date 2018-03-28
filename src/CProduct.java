import java.io.PrintStream;

public class CProduct extends CElement {
	public String m_Name;
	public int m_Code;
	public float m_Price;
	public CProduct(String name,int code, float price) {
		m_Name=name;
		m_Code=code;
		m_Price=price;
	}
	public void Print(PrintStream out) {
		out.print("CProduct(");
		out.print(m_Name);
		out.print(",");
		out.print(m_Code);
		out.print(",");
		out.print(m_Price);
		out.print(")");
	}
}
