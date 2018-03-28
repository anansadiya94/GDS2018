import java.io.PrintStream;

public class CClient extends CElement {
	public String m_Name;
	public int m_Number;
	public CClient(String name,int number) {
		m_Name=name;
		m_Number=number;
	}
	public void Print(PrintStream out) {
		out.print("Client(");
		out.print(m_Name);
		out.print(",");
		out.print(m_Number);
		out.print(")");
	}
}

