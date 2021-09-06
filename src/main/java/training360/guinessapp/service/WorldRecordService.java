package training360.guinessapp.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import training360.guinessapp.NotFoundException;
import training360.guinessapp.dto.WorldRecordDto;
import training360.guinessapp.repository.RecorderRepository;
import training360.guinessapp.repository.WorldRecordRepository;
import training360.guinessapp.dto.BeatWorldRecordCommand;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.entity.Recorder;
import training360.guinessapp.entity.WorldRecord;
import java.lang.reflect.Type;
import java.util.List;

@Service
@AllArgsConstructor
public class WorldRecordService {

    private WorldRecordRepository worldRecordRepository;

    private ModelMapper modelMapper;

    private RecorderRepository recorderRepository;

    public List<WorldRecordDto> listWorldRecords() {
        Type targetType = new TypeToken<List<WorldRecordDto>>(){}.getType();
        return modelMapper.map(worldRecordRepository.findAll(), targetType);
    }

    public WorldRecordDto saveNewWorldRecord(WorldRecordCreateCommand command) {
        WorldRecord worldRecord = new WorldRecord(command.getDescription(),
                command.getValue(), command.getUnitOfMeasure(), command.getDate(), command.getOldRecorderId());
        worldRecordRepository.save(worldRecord);
        return modelMapper.map(worldRecord, WorldRecordDto.class);
    }

    public void deleteWorldRecordById(long id) {
        worldRecordRepository.deleteById(id);
    }

    @Transactional
    public WorldRecordDto beatWorldRecord(long id, BeatWorldRecordCommand command) {
        Recorder recorder = recorderRepository.findById(id).orElseThrow(()-> new NotFoundException(id, "Recorder"));
        WorldRecord worldRecord = new WorldRecord(command.getDescription(), command.getValue(),
                command.getUnitOfMeasure(), command.getDate(), command.getOldRecorderId());
        recorder.addRecord(worldRecord);
        worldRecord.setRecorder(recorder);
        return modelMapper.map(worldRecord, WorldRecordDto.class);
    }
}
