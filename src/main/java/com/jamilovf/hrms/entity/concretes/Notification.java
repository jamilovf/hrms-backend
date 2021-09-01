package com.jamilovf.hrms.entity.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "notification")
public class Notification {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)

    @JoinColumn(name = "notification_type_id")
    @ManyToOne(optional = false)
    private NotificationType notificationType;

    @JoinColumn(name = "person_id")
    @ManyToOne
    private Person person;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

}
