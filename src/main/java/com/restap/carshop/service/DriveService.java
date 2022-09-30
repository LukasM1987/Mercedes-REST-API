package com.restap.carshop.service;

import com.restap.carshop.domain.Drive;
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

    public Optional<Drive> getDrive(final Long id) {
        return driveRepository.findById(id);
    }

    public void deleteDrive(final Long id) {
        driveRepository.deleteById(id);
    }
}
