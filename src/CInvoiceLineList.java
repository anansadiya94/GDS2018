public class CInvoiceLineList extends CList {
	public CInvoiceLine SearchByName(String name) {
		CNode node=m_Start;
		while (node!=null) {
			if (((CInvoiceLine) node.m_Element).m_Product.m_Name.equalsIgnoreCase(name)) {
				return (CInvoiceLine) node.m_Element;				
			}
			node=node.m_Next;
		}
		return null;
	}
	public CInvoiceLine SearchByCode(int code) {
		CNode node=m_Start;
		while (node!=null) {
			if (((CInvoiceLine) node.m_Element).m_Product.m_Code==code) {
				return (CInvoiceLine) node.m_Element;
			}
			node=node.m_Next;
		}
		return null;
	}
	public void PushBack(CInvoiceLine e) {
		super.PushBack(e);
	}
}