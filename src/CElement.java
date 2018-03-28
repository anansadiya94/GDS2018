import java.io.PrintStream;

public class CElement {
	public void Print(PrintStream out) {
		out.print("Element()");
	}
	
	public float Factura(PrintStream out, float total) {
		out.print("Factura()");
		return 0;
	}
	public void getNumber(PrintStream out) {
		out.print("getNumber()");
	}
	public void getDate(PrintStream out) {
		out.print("getDate()");
	}
	public void getName(PrintStream out) {
		out.print("getName()");
	}
	public void printFact(PrintStream out, int i) {
		out.print("printFact()");
	}
	
}

