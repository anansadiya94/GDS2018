public class CProductList extends CList {
	public CProduct SearchByName(String name) {
		CNode node=m_Start;
		while (node!=null) {
			if (((CProduct) node.m_Element).m_Name.equalsIgnoreCase(name)) {
				return (CProduct) node.m_Element;				
			}
			node=node.m_Next;
		}
		return null;
	}
	public CProduct SearchByCode(int code) {
		CNode node=m_Start;
		while (node!=null) {
			if (((CProduct) node.m_Element).m_Code==code) {
				return (CProduct) node.m_Element;
			}
			node=node.m_Next;
		}
		return null;
	}
	public void PushBack(CProduct e) {
		super.PushBack(e);
	}
}
