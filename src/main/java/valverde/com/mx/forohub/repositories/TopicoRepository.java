package valverde.com.mx.forohub.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import valverde.com.mx.forohub.models.Topico;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    List<Topico> findTop10ByOrderByFechaCreacionAsc();

    Page<Topico> findTopicoByCurso(String cursoNombre, Pageable pageable);

    Page<Topico> findByFechaCreacionBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);

}
