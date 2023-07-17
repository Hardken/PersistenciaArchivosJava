package Modelo;
import java.io.EOFException; 
import java.io.File;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.FileOutputStream; 
import java.io.IOException;
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel; 
public class Empleado extends Personal{
private double sueldo; 
private String cargo; 
File archivo;
ObjectInputStream entrada; 
ObjectOutputStream salida;
String titulos[]={"Identificacion", "Nombre","Cargo","Salario"}; 
DefaultTableModel modelo=new DefaultTableModel(null,titulos); 
public Empleado(){
try{
String encontrar="datos.txt"; archivo=new File(encontrar); 
if (!archivo.exists())
{
salida=new ObjectOutputStream(new FileOutputStream("datos.txt"));
}
} catch(IOException ex) {
JOptionPane.showMessageDialog( null, "Error de E/S", "Leer Archivo",
JOptionPane.ERROR_MESSAGE );
}

}
public Empleado(String identificacion, String nombre, String cargo, double sueldo) { super(identificacion, nombre);
this.cargo=cargo; this.sueldo = sueldo;
}
public void adicionar(Empleado empleado) { try {
MiObjectOutputStream salida = new MiObjectOutputStream( new FileOutputStream("datos.txt",true));
salida.writeObject(empleado); JOptionPane.showMessageDialog( null,"Registro Guardado!!!",
"Adición de información", JOptionPane.WARNING_MESSAGE );
} catch(IOException ex) {}
}
public DefaultTableModel mostrar() { try {
entrada = new ObjectInputStream(new FileInputStream("datos.txt"));
 
Object fila[]=new Object[4]; while (true){
Empleado empleado = (Empleado) entrada.readObject(); fila[0]=empleado.getIdentificacion(); fila[1]=empleado.getNombre(); fila[2]=empleado.getCargo(); fila[3]=empleado.getSueldo();
modelo.addRow(fila);
}
} catch ( EOFException ex ) {
JOptionPane.showMessageDialog( null, "Información leida, de clic en el boton", "Fin del Archivo", JOptionPane.ERROR_MESSAGE );
} catch(ClassNotFoundException ex) {
JOptionPane.showMessageDialog( null, "Clase No encontrada", "Leer Archivo",
JOptionPane.ERROR_MESSAGE );
} catch(FileNotFoundException ex) {
JOptionPane.showMessageDialog( null, "No se pudo leer el archivo", "Leer Archivo",
JOptionPane.ERROR_MESSAGE );
} catch(IOException ex) {
JOptionPane.showMessageDialog( null, "Error de E/S", "Leer Archivo",
JOptionPane.ERROR_MESSAGE );
}
return modelo;
}
public double getSueldo() { return sueldo;
}
public String getCargo() { return cargo;
 
}

}
