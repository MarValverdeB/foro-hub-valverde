package valverde.com.mx.forohub.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "topico")
@Data
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Titulo es requerido")
    @Size(max = 200, message = "Titulo no puede exceder de 200 caracteres")
    private String titulo;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Mensaje es requerido")
    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @NotBlank(message = "Estatus es requerido")
    private String status;

    private String usuario;

    private String curso;

}
