package com.example.backendengineeringwork.mappers;

import com.example.backendengineeringwork.commands.engine.CreateEngineCommand;
import com.example.backendengineeringwork.dtos.engine.EngineDto;
import com.example.backendengineeringwork.models.Engine;
import org.springframework.stereotype.Component;

@Component
public class EngineMapper {
    public static EngineDto toDto(Engine engine){
        return EngineDto.builder()
                .id(engine.getId())
                .engineCapacity(engine.getEngineCapacity())
                .power(engine.getPower())
                .torque(engine.getTorque())
                .fuel(engine.getFuel())
                .build();
    }

    public static Engine fromCommand(CreateEngineCommand command){
        return Engine.builder()
                .engineCapacity(command.getEngineCapacity())
                .power(command.getPower())
                .torque(command.getTorque())
                .fuel(command.getFuel())
                .build();
    }
}
