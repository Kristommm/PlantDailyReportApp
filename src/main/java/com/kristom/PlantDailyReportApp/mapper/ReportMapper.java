package com.kristom.PlantDailyReportApp.mapper;

import com.kristom.PlantDailyReportApp.model.dtos.ReportDto;
import com.kristom.PlantDailyReportApp.model.entities.ReportEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReportMapper {

    ReportMapper INSTANCE = Mappers.getMapper(ReportMapper.class);

    ReportEntity reportDtoToReportEntity(ReportDto report);

    ReportDto reportEntityToReportDto(ReportEntity report);

}
