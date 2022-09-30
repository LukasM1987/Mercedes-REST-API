package com.restap.carshop.mapper;

import com.restap.carshop.domain.Drive;
import com.restap.carshop.dto.DriveDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriveMapper {

    public Drive mapToDrive(final DriveDto driveDto) {
        return new Drive(driveDto.getId(), driveDto.getType(), driveDto.getPrice());
    }

    public DriveDto mapToDriveDto(final Drive drive) {
        return new DriveDto(drive.getId(), drive.getType(), drive.getPrice());
    }

    public List<DriveDto> mapToDriveDtoList(final List<Drive> drives) {
        return drives.stream().map(this::mapToDriveDto).collect(Collectors.toList());
    }
}
