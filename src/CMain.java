import java.util.Scanner;
import java.io.*;

public class CMain {
	// Rellenar con los datos de los dos alumnos que presentan la practica
	static String NombreAlumno1="anan";
	static String ApellidosAlumno1="sadiya";
	static String NIUAlumno1="1431013"; // NIU alumno1
	static String NombreAlumno2="rafa";
	static String ApellidosAlumno2="gomez perez";
	static String NIUAlumno2="1430965"; // NIU alumno2

	static String[] NIUS={
		"0000000",
		"1272977", "1397750", "1331749", "1393102",	"1397753", "1390131", 
		"1395031", "1325938", "1364251", "1358298", "1218811", "1391880",
		"1360750", "1390203", "1397769", "1391969",	"1362406", "1368533",
		"1425085", "1391810", "1359668", "1424695",	"1337981", "1341223",
		"1390130", "1337483", "1423211", "1341199", "1368624", "1191132",
		"1362742", "1237310", "1391629", "1390932", "1430965", "1423193", 
		"1366077", "1400214", "1391319", "1391317", "1295920", "1295923",
		"1391403", "1391661", "1306688", "1308352", "1333730", "1423737",
		"1424859", "1423761", "1424741", "1389961", "1264824", "1424860",
		"1337854", "1397830", "1360566", "1395062", "1423209", "1358297",
		"1331964", "1363460", "1368594", "1424717", "1391649", "1424858",
		"1424803", "1358255", "1361405", "1425068", "1391646", "1424669",
		"1212719", "1236986", "1365589", "1331661", "1371024", "1423195",
		"1426418", "1360352", "1391662", "1431013", "1360096", "1428328",
		"1417251"	
		};

	static boolean NIUCorrecto(String nia) {
		for (int i=0;i<NIUS.length; ++i) if (nia.equals(NIUS[i])) return true;
		return false;
	}

	public static class CSyntaxError extends Exception {
		private static final long serialVersionUID=2001L;
	    public CSyntaxError(String msg) {
	        super(msg);
	    }
	}
	static CInvoicing m_Invoicing;
	static int nLine=0;
	static void ProcesarNuevo(Scanner sl) throws Exception {
		String elemento=sl.next();
		if (elemento.equalsIgnoreCase("Cliente")) {
			String nombre=sl.next();
			int numero= sl.nextInt();
			if (numero<1) throw new Exception("numero de cliente menor que 1 " + numero);
			m_Invoicing.NewClient(new CClient(nombre,numero));
		} 
		else if (elemento.equalsIgnoreCase("Producto")) {
			String nombre=sl.next();
			int codigo= sl.nextInt();
			if (codigo<1) throw new Exception("codigo de producto menor que 1 " + codigo);
			m_Invoicing.NewProduct(new CProduct(nombre,codigo));
		}
		else if (elemento.equalsIgnoreCase("Factura")) {
			int numero=sl.nextInt();
			String nombreCliente= sl.next();
			if (numero<1) throw new Exception("numero de factura menor que 1 " + numero);
			m_Invoicing.NewInvoice(new CInvoice(numero,m_Invoicing.FindClientByName(nombreCliente)));			
		}
		else if (elemento.equalsIgnoreCase("Linea")) {
			int numeroFactura= sl.nextInt();
			String nombreProducto= sl.next();
			CInvoice factura=m_Invoicing.FindInvoiceByNumber(numeroFactura);
			CProduct producto=m_Invoicing.FindProductByName(nombreProducto);
			m_Invoicing.AddProductoToInvoice(factura, producto);			
		}
		else throw new CSyntaxError("Nuevo ...");
	}
	static void ProcesarModificar(Scanner sl) throws Exception {
		String elemento=sl.next();
		if (elemento.equalsIgnoreCase("Cliente")) {
			String nombreCliente=sl.next();
			CClient cliente=m_Invoicing.FindClientByName(nombreCliente);
			String campo=sl.next();
			if (campo.equalsIgnoreCase("Nombre")) {
				String nuevoNombre=sl.next();
				m_Invoicing.UpdateClient(cliente, nuevoNombre, cliente.m_Number);
			}
			else if (campo.equalsIgnoreCase("Numero")) {
				int nuevoNumero=sl.nextInt();
				m_Invoicing.UpdateClient(cliente, cliente.m_Name,nuevoNumero);				
			}
			else throw new CSyntaxError("Modificar Cliente ...");
		} 
		else if (elemento.equalsIgnoreCase("Producto")) {
			String nombreProducto=sl.next();
			CProduct producto=m_Invoicing.FindProductByName(nombreProducto);
			String campo=sl.next();
			if (campo.equalsIgnoreCase("Nombre")) {
				String nuevoNombre=sl.next();
				m_Invoicing.UpdateProduct(producto, nuevoNombre, producto.m_Code);
			}
			else if (campo.equalsIgnoreCase("Codigo")) {
				int nuevoCodigo=sl.nextInt();
				m_Invoicing.UpdateProduct(producto, producto.m_Name, nuevoCodigo);
			}
			else throw new CSyntaxError("Modificar Producto ...");
		}
		else if (elemento.equalsIgnoreCase("Factura")) {
			int numeroFactura=sl.nextInt();
			CInvoice factura=m_Invoicing.FindInvoiceByNumber(numeroFactura);
			String campo=sl.next();
			if (campo.equalsIgnoreCase("Cliente")) {
				String nuevoCliente=sl.next();
				CClient cliente=m_Invoicing.FindClientByName(nuevoCliente);
				m_Invoicing.UpdateInvoiceHeader(factura,factura.m_Number,cliente);
			}
			else if (campo.equalsIgnoreCase("Numero")) {
				int nuevoNumero=sl.nextInt();
				m_Invoicing.UpdateInvoiceHeader(factura,nuevoNumero,factura.m_Client);
			}
			else throw new CSyntaxError("Modificar Factura ...");
		}		
	}
	static void ProcesarEliminar(Scanner sl) throws Exception {
		String elemento=sl.next();
		if (elemento.equalsIgnoreCase("Cliente")) {
			String nombreCliente=sl.next();
			CClient cliente=m_Invoicing.FindClientByName(nombreCliente);
			m_Invoicing.DeleteClient(cliente);
		} 
		else if (elemento.equalsIgnoreCase("Producto")) {
			String nombreProducto=sl.next();
			CProduct producto=m_Invoicing.FindProductByName(nombreProducto);
			m_Invoicing.DeleteProduct(producto);
		}
		else if (elemento.equalsIgnoreCase("Factura")) {
			int numeroFactura=sl.nextInt();
			CInvoice factura=m_Invoicing.FindInvoiceByNumber(numeroFactura);
			m_Invoicing.DeleteInvoice(factura);
		}		
		else if (elemento.equalsIgnoreCase("Linea")) {
			int numeroFactura= sl.nextInt();
			String nombreProducto= sl.next();
			CInvoice factura=m_Invoicing.FindInvoiceByNumber(numeroFactura);
			CProduct producto=m_Invoicing.FindProductByName(nombreProducto);
			m_Invoicing.DeleteProductFromInvoice(factura, producto);			
		}
		else throw new CSyntaxError("Eliminar ...");
	}
	static void ProcesarVer(Scanner sl)  throws Exception {
		String elemento=sl.next();
		if (elemento.equalsIgnoreCase("Clientes")) {
			System.out.print(nLine + " : Salida : ");
			m_Invoicing.m_Clients.Print(System.out);
			System.out.println();
		} 
		else if (elemento.equalsIgnoreCase("Productos")) {
			System.out.print(nLine + " : Salida : ");
			m_Invoicing.m_Products.Print(System.out);
			System.out.println();
		}
		else if (elemento.equalsIgnoreCase("Facturas")) {
			System.out.print(nLine + " : Salida : ");
			m_Invoicing.m_Invoices.Print(System.out);			
			System.out.println();
		}
		else throw new CSyntaxError("Ver ...");		
	}
	public static void main(String[] args) throws Exception {
		System.out.println(NIUAlumno1);
		System.out.println(NombreAlumno1);
		System.out.println(ApellidosAlumno1);
		System.out.println(NIUAlumno2);
		System.out.println(NombreAlumno2);
		System.out.println(ApellidosAlumno2);
		
		if (!NIUCorrecto(NIUAlumno1)) throw new Exception("El NIU " + NIUAlumno1 + " no es de alumno matriculado");
		if (!NIUCorrecto(NIUAlumno2)) throw new Exception("El NIU " + NIUAlumno2 + " no es de alumno matriculado");

		m_Invoicing=new CInvoicing();
		if (args.length!=1) {
			System.out.println("Falta el nombre del fichero de ordendes");
			return;
		}
		String filename=args[0];
		System.out.println("Fichero de ordenes: " + filename);
		try {
			File ordenes=new File(filename);
			Scanner s;
			s = new Scanner(ordenes);
			while (s.hasNextLine()) {
				try {
					++nLine;
					String linea = s.nextLine();
					System.out.println(nLine + " : Linea : " + linea);
					Scanner sl = new Scanner(linea);
					//sl.useDelimiter("\\s*");
					try {
						String orden=sl.next();
						if (orden.equalsIgnoreCase("Nuevo")) ProcesarNuevo(sl);
						else if (orden.equalsIgnoreCase("Nueva")) ProcesarNuevo(sl);
						else if (orden.equalsIgnoreCase("Modificar")) ProcesarModificar(sl);
						else if (orden.equalsIgnoreCase("Eliminar")) ProcesarEliminar(sl);
						else if (orden.equalsIgnoreCase("Ver")) ProcesarVer(sl);
						else {
							sl.close();
							throw new CSyntaxError("Orden no reconocida " + linea);
						}
					}
					catch (java.util.NoSuchElementException e) {
						throw new CSyntaxError("Error de sintaxis: " + linea);
					}
				}
				catch (Exception e) {
					System.out.println(nLine + " : Excepcion : "+ e.toString());
					//e.printStackTrace();
				}
				
				catch (AssertionError e)  {
					System.out.println(nLine + " : Assert : "+ e.toString());
					//e.printStackTrace();		
				}
			}
			s.close();
		} 
		catch (Exception e) {
			System.out.println("Excepcion no controlada");
			e.printStackTrace();
		}
	}
}
