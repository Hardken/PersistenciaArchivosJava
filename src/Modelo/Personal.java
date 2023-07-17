package Modelo;
import java.io.Serializable;
public class Personal implements Serializable{ 
    private String identificacion, nombre;
public Personal(String identificacion, String nombre) { this.nombre=nombre; this.identificacion=identificacion;
}
public Personal() { }
public String getIdentificacion() { return identificacion;
}
public void setIdentificacion(String identificacion) { this.identificacion = identificacion;
}
public String getNombre() { return nombre;
}
public void setNombre(String nombre) { this.nombre = nombre;
 
}

}
