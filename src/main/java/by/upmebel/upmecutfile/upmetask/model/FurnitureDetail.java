package by.upmebel.upmecutfile.upmetask.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@ToString
@Table(name = "furniture")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class FurnitureDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "furnitureSeqGenerator")
    @SequenceGenerator(name = "furnitureSeqGenerator", sequenceName = "furniture_seq", allocationSize = 1)
    private Long id;
    private Double height;

    @OneToMany(mappedBy = "furnitureDetail", cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<Hole> holes = new ArrayList<>();
}