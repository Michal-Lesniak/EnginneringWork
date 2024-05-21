package com.example.backendengineeringwork.services;

import com.example.backendengineeringwork.commands.city.CityCreateCommand;
import com.example.backendengineeringwork.dtos.city.CityDto;
import com.example.backendengineeringwork.exceptions.ArgumentCannotBeNullException;
import com.example.backendengineeringwork.exceptions.NotFoundException;
import com.example.backendengineeringwork.mappers.CityMapper;
import com.example.backendengineeringwork.models.City;
import com.example.backendengineeringwork.repositories.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.backendengineeringwork.mappers.CityMapper.fromCommand;
import static com.example.backendengineeringwork.mappers.CityMapper.toDto;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    @Transactional(readOnly = true)
    public List<CityDto> findAll() {
        return cityRepository.findAll().stream()
                .map(CityMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public CityDto findById(long id) {
        City city = cityRepository.findById(id).orElseThrow(
                () -> new NotFoundException("City with id: " + id + " not found")
        );
        return toDto(city);
    }

    @Transactional
    public CityDto update(long id, CityCreateCommand command) {
        if (command == null) throw new ArgumentCannotBeNullException("City cannot be null");

        City city = cityRepository.findByIdWithLock(id).orElseThrow(
                () -> new NotFoundException("City with id: " + id + " not found")
        );
        city.setName(command.getName());
        return toDto(city);
    }

    @Transactional
    public CityDto save(CityCreateCommand command) {
        if (command == null) throw new ArgumentCannotBeNullException("City cannot be null");

        City city = cityRepository.save(fromCommand(command));
        return toDto(city);
    }

    public void deleteById(long id) {
        cityRepository.deleteById(id);
    }


}
