
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="agents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agent extends User {

    private String specialite;
}
