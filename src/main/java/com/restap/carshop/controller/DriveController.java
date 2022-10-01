package com.restap.carshop.controller;

import com.restap.carshop.domain.Drive;
import com.restap.carshop.dto.DriveDto;
import com.restap.carshop.exception.DriveException;
import com.restap.carshop.mapper.DriveMapper;
import com.restap.carshop.service.DriveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/drives")
@RequiredArgsConstructor
public class DriveController {

    private final DriveService driveService;
    private final DriveMapper driveMapper;

    @RequestMapping(method = RequestMethod.POST, value = "addDrive", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addDrive(@RequestBody final DriveDto driveDto) {
        Drive drive = driveMapper.mapToDrive(driveDto);
        driveService.addDrive(drive);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteDrive")
    public void deleteDrive(@RequestParam final Long id) throws DriveException {
        driveService.deleteDrive(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getDrives")
    public List<DriveDto> getDrives() {
        List<Drive> drives = driveService.getAllDrives();
        return driveMapper.mapToDriveDtoList(drives);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getDrive")
    public DriveDto getDrive(@RequestParam final Long id) throws DriveException {
        return driveMapper.mapToDriveDto(driveService.getDriveById(id));
    }
}
