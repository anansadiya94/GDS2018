
public class CInvoicing {
	CClientList m_Clients;
	CProductList m_Products;
	CInvoiceList m_Invoices;
	public CInvoicing() {
		m_Clients=new CClientList();
		m_Products=new CProductList();
		m_Invoices=new CInvoiceList();
	}
	// Clientes ----------------------------------------------------------------
	public static class CClientNotFound extends Exception {
		private static final long serialVersionUID=1001L;
	    public CClientNotFound(String msg) {
	        super(msg);
	    }
	}
	
	public static class CClientAlreadyExist extends Exception {
		private static final long serialVersionUID = 1525448168999578009L;
		public CClientAlreadyExist(String msg) {
			super(msg);
		}
	}
	public  static class CClientDuplicatedName extends Exception {
		private static final long serialVersionUID=1002L;
	    public CClientDuplicatedName(String msg) {
	        super(msg);
	    }
	}
	public  static class CClientDuplicatedNumber extends Exception {
		private static final long serialVersionUID=1003L;
	    public CClientDuplicatedNumber(String msg) {
	        super(msg);
	    }
	}
	public  static class CClientHasInvoices extends Exception {
		private static final long serialVersionUID=1004L;
	    public CClientHasInvoices(String msg) {
	        super(msg);
	    }
	}
	public void NewClient(CClient client) throws Exception {
		if(m_Clients.clientHasName(client)) throw new CClientAlreadyExist("nombre de cliente duplicado " + client.m_Name);
		if(m_Clients.clientHasID(client)) throw new CClientAlreadyExist("numero de cliente duplicado " + client.m_Number);		
		m_Clients.PushBack(client);
	}
	public void DeleteClient(CClient client) throws Exception {
		if (!m_Clients.MemberP(client))  throw new CClientNotFound("Cliente no encontrado" + client.m_Name);
		if (m_Invoices.ClientHasInvoices(client)) throw new CClientHasInvoices("El cliente tiene facturas " + client.m_Name);
		m_Clients.Delete(client);
	}
	public CClient FindClientByName(String name) throws Exception {
		CClient c=m_Clients.SearchByName(name);
		if (c==null) throw new CClientNotFound("No se ha encontrado el cliente " + name);
		return c;
	}
	public CClient FindClientByNumber(int number)  throws Exception {
		CClient c=m_Clients.SearchByNumber(number);
		if (c==null) throw new CClientNotFound("No se ha encontrado el cliente con numero " + number);
		return c;
	}
	public void UpdateClient(CClient client, String name, int number) throws Exception {
		if (!m_Clients.MemberP(client)) throw new CClientNotFound("El cliente a modificar no pertenece a la lista de clientes");
		if(!m_Clients.clientHasName(client)) throw new CClientAlreadyExist("nombre de cliente no existe " + client.m_Name);
		if(m_Clients.clientHasIDM(number)) throw new CClientAlreadyExist("numero de cliente duplicado " + number);
		client.m_Name=name;
		client.m_Number=number;
	}
	// Productos ---------------------------------------------------------------
	public class CProductNotFound extends Exception {
		private static final long serialVersionUID=1005L;
	    public CProductNotFound(String msg) {
	        super(msg);
	    }
	}
	public class CProductDuplicatedName extends Exception {
		private static final long serialVersionUID=1006L;
	    public CProductDuplicatedName(String msg) {
	        super(msg);
	    }
	}
	public class CProductDuplicatedCode extends Exception {
		private static final long serialVersionUID=1007L;
    public CProductDuplicatedCode(String msg) {
	        super(msg);
	    }
	}
	public class CProductInInvoices extends Exception {
		private static final long serialVersionUID=1008L;
	    public CProductInInvoices(String msg) {
	        super(msg);
	    }
	}
	public void NewProduct(CProduct product) throws Exception {
		assert product!=null;
		if (m_Products.SearchByName(product.m_Name)!=null) throw new CProductDuplicatedName("nombre de producto duplicado " + product.m_Name);
		if (m_Products.SearchByCode(product.m_Code)!=null) throw new CProductDuplicatedCode("codigo de producto duplicado " + product.m_Code);
		m_Products.PushBack(product);
	}
	public void DeleteProduct(CProduct product) throws Exception {
		if (!m_Products.MemberP(product))  throw new CProductNotFound("Producto no encontrado " + product.m_Name);
		if (m_Invoices.ProductInInvoices(product)) throw new CProductInInvoices("El producto esta en facturas " + product.m_Name);
		m_Products.Delete(product);
	}
	public CProduct FindProductByName(String name) throws Exception {
		CProduct p=m_Products.SearchByName(name);
		if (p==null) throw new CProductNotFound("No se ha encontrado el producto " + name);
		return p;
	}
	public CProduct FindProductByCode(int code) throws Exception {
		CProduct p=m_Products.SearchByCode(code);
		if (p==null) throw new CProductNotFound("No se ha encontrado el producto con codigo " + code);
		return p;
	}
	public void UpdateProduct(CProduct product, String name, int code) throws Exception {
		if (!m_Products.MemberP(product)) throw new CProductNotFound("El producto a modificar no pertenece a la lista de productos");
		if (!product.m_Name.equalsIgnoreCase(name) && m_Products.SearchByName(name)!=null) throw new CProductDuplicatedName("nombre de producto duplicado " + name);
		if (product.m_Code!=code && m_Products.SearchByCode(code)!=null) throw new CProductDuplicatedCode("codigo de producto duplicado " + code);
		product.m_Name=name;
		product.m_Code=code;
	}
	// Facturas ----------------------------------------------------------------
	public class CInvoiceNotFound extends Exception {
		private static final long serialVersionUID=1009L;
	    public CInvoiceNotFound(String msg) {
	        super(msg);
	    }
	}
	public class CInvoiceDuplicatedNumber extends Exception {
		private static final long serialVersionUID=1010L;
	    public CInvoiceDuplicatedNumber(String msg) {
	        super(msg);
	    }
	}
	public void NewInvoice(CInvoice invoice) throws Exception {
		if (!m_Clients.MemberP(invoice.m_Client)) throw new CClientNotFound("El cliente de la factura no perteneces a la lista de clientes");
		if (m_Invoices.InvoceHasNumber(invoice.m_Number)) throw new CInvoiceDuplicatedNumber ("numero de factura duplicado:" + invoice.m_Number);
		//if (m_Invoices.SearchByNumber(invoice.m_Number)!=null) throw new CInvoiceDuplicatedNumber ("numero de factura duplicado:" + invoice.m_Number);
		m_Invoices.PushBack(invoice);
	}

	public void DeleteInvoice(CInvoice invoice) throws Exception {
		if (!m_Invoices.MemberP(invoice))  throw new CInvoiceNotFound("Factura no encontrada " + invoice.m_Number);
		m_Invoices.Delete(invoice);
	}
	public CInvoice FindInvoiceByNumber(int number) throws Exception {
		CInvoice invoice=m_Invoices.SearchByNumber(number);
		if (invoice==null)  throw new CInvoiceNotFound("Factura no encontrada " + number);
		return invoice;
	}
	public void UpdateInvoiceHeader(CInvoice invoice, int number,CClient client) throws Exception {
		if (!m_Invoices.MemberP(invoice))  throw new CInvoiceNotFound("Factura no encontrada " + invoice.m_Number);
		if (!m_Clients.MemberP(client))  throw new CClientNotFound("Cliente no encontrado " + client.m_Name);
		invoice.m_Number=number;
		invoice.m_Client=client;
	}
	public void AddProductoToInvoice(CInvoice invoice, CProduct product, int quantity) throws Exception {
		if (!m_Invoices.MemberP(invoice))  throw new CInvoiceNotFound("Factura no encontrada " + invoice.m_Number);
		if (!m_Products.MemberP(product))  throw new CProductNotFound("Producto no encontrado " + product.m_Name);
		if (invoice.m_Lines.MemberP(product)) throw new Exception("Producto duplicado en factura " + product.m_Name);
		invoice.AddProduct(new CInvoiceLine(product, quantity));
	}
	public void DeleteProductFromInvoice(CInvoice invoice, CProduct product) throws Exception {
		if (!m_Invoices.MemberP(invoice))  throw new CInvoiceNotFound("Factura no encontrada " + invoice.m_Number);
		if (!invoice.m_Lines.MemberP(product))  throw new CProductNotFound("Producto no encontrado " + product.m_Name);
		invoice.DeleteProduct(new CInvoiceLine(product, 1));
	}
}
