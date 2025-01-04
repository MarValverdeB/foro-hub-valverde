package valverde.com.mx.forohub.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "rol")
@Data
public class Rol {

    @Id
    private Integer idRol;

    @Column(nullable = false, length = 15)
    private String nombre;

    @Column(nullable = true, length = 150)
    private String descripcion;

}
