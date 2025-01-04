package valverde.com.mx.forohub.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import valverde.com.mx.forohub.models.Topico;
import valverde.com.mx.forohub.repositories.TopicoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TopicoServiceImpl implements TopicoService {

    private final TopicoRepository topicoRepository;

    @Override
    public Topico getTopicById(Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        return topico.isPresent() ? topico.get() : new Topico();
    }

    @Override
    public List<Topico> getAllTopics() {
        return topicoRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Topico createTopic(Topico topico) {
        return topicoRepository.save(topico);
    }

    @Transactional
    @Override
    public Topico updateTopic(Topico updatedTopic) {
        return topicoRepository.save(updatedTopic);
    }

    @Override
    public void deleteTopic(Long id) {
        topicoRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return topicoRepository.existsById(id);
    }

    @Override
    public List<Topico> getTop10ByOrderByFechaCreacionAsc() {
        return topicoRepository.findTop10ByOrderByFechaCreacionAsc()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public Page<Topico> getByCursoNombre(String cursoNombre, Pageable pageable) {
        return topicoRepository.findTopicoByCurso(cursoNombre, pageable);
    }

    @Override
    public Page<Topico> getByFechaCreacionBetween(LocalDate startDate, LocalDate endDate, Pageable pageable) {
        return topicoRepository.findByFechaCreacionBetween(startDate, endDate, pageable);
    }

}
