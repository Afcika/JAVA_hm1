import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByCountryName(String countryName);

    List<City> findByCountryNameAndPopulationGreaterThan(String countryName, int population);

    List<City> findByPopulationBetween(int minPopulation, int maxPopulation);

    List<City> findByCountryNameOrderByPopulationDesc(String countryName);

    List<City> findByCountryNameAndActiveIsTrue(String countryName);

}
