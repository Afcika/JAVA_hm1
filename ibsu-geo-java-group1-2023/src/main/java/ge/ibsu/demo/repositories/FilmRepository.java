import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FilmRepository extends JpaRepository<Film, Long> {

    @Query("SELECT f FROM Film f WHERE " +
            "(:title IS NULL OR f.title LIKE %:title%) AND " +
            "(:description IS NULL OR f.description LIKE %:description%) AND " +
            "(:releaseYear IS NULL OR f.releaseYear = :releaseYear) AND " +
            "(:language IS NULL OR f.language = :language)")
    Page<Film> search(
            String title, String description, Integer releaseYear, String language, Pageable pageable);
}
