package com.crud.basic.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import java.time.*;
import java.util.Date;
import java.util.TimeZone;

import static org.hibernate.generator.EventType.INSERT;
import static org.hibernate.generator.EventType.UPDATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @CurrentTimestamp(event = INSERT)
    private Instant createdAt;

    @CurrentTimestamp(event = {INSERT, UPDATE})
    private Instant lastUpdatedAt;

    @Column(name = "`timestamp`")
    @CreationTimestamp
    private Date timestamp; // Deprecated --> private ( Date || Calendar || Time || Timestamp ) DatCalTim;

    @Column(name = "updated_on")
    @UpdateTimestamp
    private Date updatedOn;

    @Column(name = "updated_by")
    private String updatedBy;

    private Duration duration;

    // mapped as TIMESTAMP
    private Instant instant;

    // mapped as DATE
    private LocalDate localDate;

    // mapped as TIMESTAMP
    private LocalDateTime localDateTime;

    // mapped as TIME
    private LocalTime localTime;

    // mapped as TIMESTAMP or TIMESTAMP_WITH_TIMEZONE
    @TimeZoneStorage(TimeZoneStorageType.COLUMN)
    @TimeZoneColumn(name = "birthday_offset_offset")
    @Column(name = "birthday_offset")
    private OffsetDateTime offsetDateTimeColumn;

    // mapped as TIME or TIME_WITH_TIMEZONE
    @TimeZoneStorage(TimeZoneStorageType.COLUMN)
    @TimeZoneColumn(name = "birthtime_offset_offset")
    @Column(name = "birthtime_offset")
    private OffsetTime offsetTimeColumn;

    // mapped as VARCHAR
    private TimeZone timeZone;

    // mapped as TIMESTAMP or TIMESTAMP_WITH_TIMEZONE
    @TimeZoneStorage(TimeZoneStorageType.COLUMN)
    @TimeZoneColumn(name = "birthday_zoned_offset")
    @Column(name = "birthday_zoned")
    private ZonedDateTime zonedDateTimeColumn;

    // mapped as VARCHAR
    private ZoneOffset zoneOffset;


}
