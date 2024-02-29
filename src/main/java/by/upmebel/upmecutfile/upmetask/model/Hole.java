package by.upmebel.upmecutfile.upmetask.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@Builder
@ToString
@Table(name = "holes")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Hole {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "holeSeqGenerator")
    @SequenceGenerator(name = "holeSeqGenerator", sequenceName = "hole_seq", allocationSize = 1)
    private Long id;
    private Double diameter;
    private Double depth;
    private Double entrySpeed;
    private Double exitSpeed;
    private String coordinates;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false, name = "furniture_detail_id")
    private FurnitureDetail furnitureDetail;
}
