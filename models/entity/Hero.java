package heroesproject.demo.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "heroes")
@NoArgsConstructor
@Getter
@Setter
public class Hero extends BaseEntity{

    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @NotNull
    private String className;
    @Min(value = 1)
    private int level;
}
