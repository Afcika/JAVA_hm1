import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    @GetMapping("/actors")
    public List<ActorDTO> getAllActors() {
        List<Actor> actors = actorRepository.findAll();
        return actors.stream()
                .map(actor -> new ActorDTO(actor.getFirstName(), actor.getLastName()))
                .collect(Collectors.toList());
    }
}
