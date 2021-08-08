package br.com.dio.pointcontrol.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class DataType {
    @Id
    private Long id;
    private String description;
}
