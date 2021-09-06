package training360.guinessapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.service.RecorderService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/recorders")
@AllArgsConstructor
public class RecorderController {

    private RecorderService recorderService;


    @GetMapping
    @Tag(name = "GET")
    @Operation(summary = "Listing recorders", description = "This option is for listing all the recorders")
    public List<RecorderDto> listRecorders() {return recorderService.listRecorders();
    }

    @PostMapping
    @Tag(name = "POST")
    @Operation(summary = "Saving a new recorder", description = "This option is for saving a new recorder")
    @ApiResponse(responseCode = "201", description = "New recorder has been saved")
    @ApiResponse(responseCode = "400", description = "Validation exception while saving a new recorder")
    @ResponseStatus(HttpStatus.CREATED)
    public RecorderDto saveNewRecorder(@Valid @RequestBody RecorderCreateCommand command) {
        return recorderService.saveNewRecorder(command);
    }

    @DeleteMapping("/{id}")
    @Tag(name = "DELETE")
    @Operation(summary = "Deleting a recorder", description = "This option is for deleting a recorder by ID")
    @ApiResponse(responseCode = "204", description = "Recorder has been deleted")
    @ApiResponse(responseCode = "404", description = "Recorder not found")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecorderById(@PathVariable("id") long id) {
        recorderService.deleteRecorderById(id);
    }
}
