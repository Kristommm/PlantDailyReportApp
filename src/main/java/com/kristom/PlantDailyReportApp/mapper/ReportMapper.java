package com.kristom.PlantDailyReportApp.mapper;

import com.kristom.PlantDailyReportApp.domain.dtos.ReportDto;
import com.kristom.PlantDailyReportApp.domain.entities.Report;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReportMapper {

    ReportMapper INSTANCE = Mappers.getMapper(ReportMapper.class);

    Report toReport(ReportDto reportDto);

    ReportDto toReportDto(Report report);

}
