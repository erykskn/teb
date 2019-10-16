package com.teb.job.producer;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Log")
@Table(name = "log", schema = "kafka")
@SequenceGenerator(name = "seq", initialValue = 1)
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "log_detail")
    private String logDetail;

    @Column(name = "log_level")
    @Enumerated(EnumType.STRING)
    private LogLevel logLevel;

    @Column(name = "server_city_name")
    private String serverCityName;

    public Log() {

    }

    public Log(Date createdDate, String logDetail, LogLevel logLevel, String serverCityName) {
        this.createdDate = createdDate;
        this.logDetail = logDetail;
        this.logLevel = logLevel;
        this.serverCityName = serverCityName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLogDetail() {
        return logDetail;
    }

    public void setLogDetail(String logDetail) {
        this.logDetail = logDetail;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public String getServerCityName() {
        return serverCityName;
    }

    public void setServerCityName(String serverCityName) {
        this.serverCityName = serverCityName;
    }

    @Override
    public String toString() {
        return this.createdDate + " " + this.logLevel.name() + " " + this.serverCityName + " " + this.logDetail;
    }
}
