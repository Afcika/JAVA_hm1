import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;
    @GetMapping("/cities")
    public List<CityDTO> getAllCitiesWithCountry() {
        List<City> cities = cityRepository.findAll();
        return cities.stream()
                .map(city -> new CityDTO(city.getName(), city.getCountry().getName()))
                .collect(Collectors.toList());
    }
}
