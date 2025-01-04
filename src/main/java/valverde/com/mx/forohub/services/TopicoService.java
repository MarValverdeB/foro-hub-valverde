package valverde.com.mx.forohub.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import valverde.com.mx.forohub.models.Topico;

import java.time.LocalDate;
import java.util.List;

public interface TopicoService {

    Topico getTopicById(Long id);

    List<Topico> getAllTopics();

    Topico createTopic(Topico topicoDTO);

    Topico updateTopic(Topico topicoDTO);

    void deleteTopic(Long id);

    boolean existsById(Long id);

    List<Topico> getTop10ByOrderByFechaCreacionAsc();

    Page<Topico> getByCursoNombre(String cursoNombre, Pageable pageable);

    Page<Topico> getByFechaCreacionBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);

}
