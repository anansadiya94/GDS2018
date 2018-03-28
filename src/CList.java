import java.io.PrintStream;

public class CList {
	class CNode {
		CNode m_Next;
		CElement m_Element;
		public CNode(CElement e) {
			m_Element=e;
			m_Next=null;
		}
	}
	protected CNode m_Start;
	protected CNode m_End;
	public CList() {
		m_Start=null;
		m_End=null;
	}
	public void Clean() {
		m_Start=null;
		m_End=null;
	}
	public void PushBack(CElement e) {
		CNode node=new CNode(e);
		if (m_End==null) {			
			m_Start=node;
			m_End=node;
		}
		else {
			m_End.m_Next=node;
			m_End=node;
			
		}
	}
	public void Delete(CElement e) {
		if (m_Start!=null) { 
			if (m_Start.m_Element==e) {
				m_Start=m_Start.m_Next;
				if (m_Start==null) m_End=null;
				return;
			}
			else {
				CNode node=m_Start;
				while (node.m_Next!=null) {
					if (node.m_Next.m_Element==e) {
						node.m_Next=node.m_Next.m_Next;
						if (node.m_Next==null) m_End=node;
						return;
					}
					node=node.m_Next;
				}
			}
		}
	}
	public boolean MemberP(CElement e) {
		CNode node=m_Start;
		while (node!=null) {
			if (node.m_Element==e) {
				return true;
			}
			node=node.m_Next;
		}
		return false;
	}
	public boolean IncludedIn(CList list) {
		CNode node=m_Start;
		while (node!=null) {
			if (!list.MemberP(node.m_Element)) {
				return false;
			}
			node=node.m_Next;
		}
		return true;		
	}
	//Nuevo metodo125 a 140. Error 1
		public boolean clientHasID(CClient c) {
			CNode node=m_Start;
			
			while (node!=null) {
				CClient cc = (CClient) node.m_Element;
				if (cc.m_Number==c.m_Number) {
					return true;
				}
				node=node.m_Next;
			}
			return false;
		}
		public boolean clientHasName(CClient c) {
			CNode node=m_Start;
			while (node!=null) {
				CClient cc = (CClient) node.m_Element;
				//System.out.println(cc.m_Name);
				//System.out.println(c.m_Name);
				if (cc.m_Name.equals(c.m_Name)) {
					return true;
				}
				node=node.m_Next;
			}
			return false;
		}
			
			public boolean clientHasIDM(int num) {
				CNode node=m_Start;
				while (node!=null) {
					CClient cc = (CClient) node.m_Element;
					if (cc.m_Number==num) {
						return true;
					}
					node=node.m_Next;
				}
				return false;
			}
	public void Print(PrintStream out) {
		out.print("[");
		CNode n=m_Start;
		while (n!=null) {
			n.m_Element.Print(out);
			n=n.m_Next;
			if (n!=null) out.print(", ");
		}
		out.print("]");
	}
}
