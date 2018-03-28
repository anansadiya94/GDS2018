public class CClientList extends CList {
	public CClient SearchByName(String name) {
		CNode node=m_Start;
		while (node!=null) {
			if (((CClient) node.m_Element).m_Name.equalsIgnoreCase(name)) {
				return (CClient) node.m_Element;
			}
			node=node.m_Next;
		}
		return null;
	}
	public CClient SearchByNumber(int number) {
		CNode node=m_Start;
		while (node!=null) {
			if (((CClient) node.m_Element).m_Number==number) {
				return (CClient) node.m_Element;
			}
			node=node.m_Next;
		}
		return null;
	}
	public void PushBack(CClient e) {
		super.PushBack(e);
	}
}
