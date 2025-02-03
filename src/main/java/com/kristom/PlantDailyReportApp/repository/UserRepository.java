package com.kristom.PlantDailyReportApp.repository;

import com.kristom.PlantDailyReportApp.model.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
