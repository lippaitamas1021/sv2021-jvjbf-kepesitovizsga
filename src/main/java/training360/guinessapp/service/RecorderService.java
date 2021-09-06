package training360.guinessapp.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import training360.guinessapp.repository.RecorderRepository;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.entity.Recorder;
import java.lang.reflect.Type;
import java.util.List;

@Service
@AllArgsConstructor
public class RecorderService {

    private RecorderRepository recorderRepository;

    private ModelMapper modelMapper;


    public List<RecorderDto> listRecorders() {
        Type targetType = new TypeToken<List<RecorderDto>>(){}.getType();
        return modelMapper.map(recorderRepository.findAll(), targetType);
    }

    public RecorderDto saveNewRecorder(RecorderCreateCommand command) {
        Recorder recorder = new Recorder(command.getName(), command.getDateOfBirth());
        recorderRepository.save(recorder);
        return modelMapper.map(recorder, RecorderDto.class);
    }

    public void deleteRecorderById(long id) {
        recorderRepository.deleteById(id);
    }
}
