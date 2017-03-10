package crudAlumno;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CrudAlumnoFactory {
	
	
	public static String init() throws IOException {
		Properties defaultProps = new Properties();
		FileInputStream in = new FileInputStream("crud.properties");
		defaultProps.load(in);
		in.close();
		return defaultProps.getProperty("tipo.crud");
	}
	
	
	
	public static CRUDAlumno getCrudAlumno() {
		String tipoCrud = "list";
		try {
			tipoCrud = init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.print("No se ha podido leer el fichero de properties. Aplicando el valor por defecto");
		}
		if (tipoCrud.equalsIgnoreCase("list"))
			return new CRUDAlumnoImpl2();
		else if (tipoCrud.equalsIgnoreCase("jdbc"))
			return new CRUDAlumnoImpl();
		else return null;
	}
	
	
	

}
