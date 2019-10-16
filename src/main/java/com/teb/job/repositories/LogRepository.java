package com.teb.job.repositories;

import com.teb.job.producer.Log;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<Log, Long> {
}
