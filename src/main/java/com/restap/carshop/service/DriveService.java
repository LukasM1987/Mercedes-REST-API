package com.restap.carshop.service;

import com.restap.carshop.domain.Drive;
import com.restap.carshop.exception.DriveException;
import com.restap.carshop.repository.DriveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriveService {

    private final DriveRepository driveRepository;

    public Drive addDrive(final Drive drive) {
        return driveRepository.save(drive);
    }

    public List<Drive> getAllDrives() {
        return driveRepository.findAll();
    }

    public Drive getDriveById(final Long id) throws DriveException {
        return driveRepository.findById(id).orElseThrow(DriveException::new);
    }

    public void deleteDrive(final Long id) throws DriveException {
        if (driveRepository.findById(id).isPresent()) {
            driveRepository.deleteById(id);
        } else {
            throw new DriveException();
        }
    }
}
