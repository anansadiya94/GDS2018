import java.io.PrintStream;

public class CProduct extends CElement {
	public String m_Name;
	public int m_Code;
	public CProduct(String name,int code) {
		m_Name=name;
		m_Code=code;
	}
	public void Print(PrintStream out) {
		out.print("CProduct(");
		out.print(m_Name);
		out.print(",");
		out.print(m_Code);
		out.print(")");
	}
}
