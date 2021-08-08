package br.com.dio.pointcontrol.model;


import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
public class AnnualLeave {
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class AnnualLeaveID implements Serializable{
        private Long idAnnualLeave;
        private Long idMovement;
        private Long idUser;
    }

    @EmbeddedId
    private AnnualLeaveID annualLeaveID;
    private LocalDateTime workingData;
    private BigDecimal amountHours;
    private BigDecimal balanceHours;
}
