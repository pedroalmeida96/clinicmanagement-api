package com.pedroalmeida.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDate;


@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseObject {

    // @CreationTimestamp
    @Column(name = "CREATION_DATE", updatable = false)
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate createdAt = null;

    // @UpdateTimestamp
    @Column(name = "MODIFICATION_DATE")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate lastModifiedAt = null;

    @Column(name = "CREATED_BY", updatable = false, length = 1024)
    private String createdBy = null;

    @Column(name = "MODIFIED_BY", length = 1024)
    private String lastModifiedBy = null;

    @PreUpdate
    protected void updateAuditInformation() {
        lastModifiedAt = LocalDate.now();
    }

    @PrePersist
    protected void generateAuditInformation() {
        createdAt = LocalDate.now();
        lastModifiedAt = LocalDate.now();
    }
}
