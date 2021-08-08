package br.com.dio.pointcontrol.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Movement {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class MovementId implements Serializable{
        private Long idMovement;
        private Long idUser;
    }

    @EmbeddedId
    private MovementId idMovement;
    private LocalDateTime entryData;
    private LocalDateTime leaveData;
    private BigDecimal period;
    @ManyToOne
    private Occurrence occurrence;
    @ManyToOne
    private Calendar calendar;
}
