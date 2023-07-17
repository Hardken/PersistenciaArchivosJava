package Controlador; 
import Modelo.Empleado;
import Vista.FormularioArchivoSecuencialHerencia; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.table.DefaultTableModel;
public class ControladorPersonaEmpleado implements ActionListener{ FormularioArchivoSecuencialHerencia objetoVista;
Empleado objetoModelo; 
Empleado empleado;
DefaultTableModel modelo =new DefaultTableModel(); 
public ControladorPersonaEmpleado() {
objetoVista=new FormularioArchivoSecuencialHerencia(); 
objetoModelo=new Empleado(); 
objetoVista.setVisible(true); 
objetoVista.getBotonguardar().addActionListener(this); 
objetoVista.getBotonregistros().addActionListener(this);
}
public void actionPerformed(ActionEvent e) { 
    if(e.getSource()==objetoVista.getBotonguardar()) {
String identificacion=objetoVista.getTxtidentificacion().getText(); 
String nombre= objetoVista.getTxtnombre().getText();
String cargo= objetoVista.getListacargo().getSelectedItem().toString(); 
double salario=Double.parseDouble(objetoVista.getListasalario().getSelectedItem().toString());
empleado=new Empleado(identificacion,nombre,cargo,salario); 
objetoModelo.adicionar(empleado); 
objetoVista.getTxtidentificacion().setText("");
 
objetoVista.getTxtnombre().setText(""); objetoVista.getTxtnombre().requestFocus();
}
if(e.getSource()==objetoVista.getBotonregistros()) { 
    modelo=(DefaultTableModel)objetoVista.getTabla().getModel(); int filas=objetoVista.getTabla().getRowCount();
for (int i = 0;filas>i; i++) modelo.removeRow(0);
modelo=objetoModelo.mostrar(); objetoVista.getTabla().setModel(modelo);
}
}

}
