package valverde.com.mx.forohub.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import valverde.com.mx.forohub.models.Topico;
import valverde.com.mx.forohub.services.TopicoService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/topicos")
@AllArgsConstructor
@Slf4j
@Validated
public class TopicController {

    private final TopicoService topicoService;

    @GetMapping("/{id}")
    public ResponseEntity<Topico> getTopic(@PathVariable Long id) {
        Topico topico = topicoService.getTopicById(id);
        return topico != null ? ResponseEntity.ok(topico) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Topico> getAllTopics(){
        return topicoService.getAllTopics();
    }

    @PostMapping
    public ResponseEntity<Topico> createTopic(@Valid @RequestBody Topico topico){
        Topico topicoResponse = topicoService.createTopic(topico);
        return ResponseEntity.ok(topicoResponse);
    }

    @PutMapping
    public ResponseEntity<Topico> updateTopic(@RequestBody Topico topico){
        Topico topicoUpdated = topicoService.updateTopic(topico);
        return topicoUpdated != null ? ResponseEntity.ok(topicoUpdated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id){
        boolean exist = topicoService.existsById(id);
        if(!exist){
            return ResponseEntity.notFound().build();
        }
        topicoService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/top10")
    public ResponseEntity<List<Topico>> getTop10ByFechaCreacion(){
        return ResponseEntity.ok(topicoService.getTop10ByOrderByFechaCreacionAsc());
    }

    @GetMapping("/byCurso")
    public ResponseEntity<Page<Topico>> getByCursoNombre(
            @RequestParam String cursoNombre,
            @PageableDefault(size = 5, sort = "fechaCreacion") Pageable pageable){

        Page<Topico> topicosByCurso = topicoService.getByCursoNombre(cursoNombre, pageable);
        return ResponseEntity.ok(topicosByCurso);
    }

    @GetMapping("/byYear")
    public ResponseEntity<Page<Topico>> getByYear(
            @RequestParam int year,
            @PageableDefault(size = 5, sort = "fechaCreacion") Pageable pageable){

        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year, 12, 31);
        Page<Topico> topicosByYear = topicoService.getByFechaCreacionBetween(startDate, endDate, pageable);
        return ResponseEntity.ok(topicosByYear);
    }

}
