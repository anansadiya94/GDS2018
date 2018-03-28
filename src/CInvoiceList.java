public class CInvoiceList extends CList {
	public CInvoice SearchByNumber(int number) {
		CNode node=m_Start;
		while (node!=null) {
			if (((CInvoice) node.m_Element).m_Number==number) {
				return (CInvoice) node.m_Element;
			}
			node=node.m_Next;
		}
		return null;
	}
	public void PushBack(CInvoice e) {
		super.PushBack(e);
	}
	public boolean ClientHasInvoices(CClient client) {
		CNode node=m_Start;
		while (node!=null) {
			if (((CInvoice) node.m_Element).m_Client==client) {
				return true;
			}
			node=node.m_Next;
		}
		return false;
	}	
	public boolean ProductInInvoices(CProduct product) {
		CNode node=m_Start;
		while (node!=null) {
			CInvoice invoice=(CInvoice) node.m_Element;
			if (invoice.m_Products.MemberP(product)) {
				return true;
			}
			node=node.m_Next;
		}
		return false;
	}
}
