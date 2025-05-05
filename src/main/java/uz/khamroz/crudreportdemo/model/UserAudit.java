package uz.khamroz.crudreportdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class UserAudit {
    @CreatedBy
    @Column(updatable = false)
    protected LocalDateTime createdDate;
    @LastModifiedBy
    protected LocalDateTime updatedDate;
}
