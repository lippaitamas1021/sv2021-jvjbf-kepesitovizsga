package training360.guinessapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.BeatWorldRecordCommand;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.dto.WorldRecordDto;
import training360.guinessapp.service.WorldRecordService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/worldrecords")
@AllArgsConstructor
public class WorldRecordController {

    private WorldRecordService worldRecordService;

    @GetMapping
    @Tag(name = "GET")
    @Operation(summary = "Listing world records", description = "This option is for listing all the world records")
    public List<WorldRecordDto> listWorldRecords() {return worldRecordService.listWorldRecords();
    }

    @PostMapping
    @Tag(name = "POST")
    @Operation(summary = "Saving a new world record", description = "This option is for saving a new world record")
    @ApiResponse(responseCode = "201", description = "New world record has been saved")
    @ApiResponse(responseCode = "400", description = "Validation exception while saving a new world record")
    @ResponseStatus(HttpStatus.CREATED)
    public WorldRecordDto saveNewWorldRecord(@Valid @RequestBody WorldRecordCreateCommand command) {
        return worldRecordService.saveNewWorldRecord(command);
    }


    @PutMapping("/{id}/beatrecords")
    @Tag(name = "PUT")
    @Operation(summary = "A recorder beats a world record")
    @ApiResponse(responseCode = "200", description = "World record has been beated")
    @ApiResponse(responseCode = "400", description = "Bad request, world record can not be updated")
    public WorldRecordDto beatWorldRecord(@PathVariable("id") long id, @Valid @RequestBody BeatWorldRecordCommand command) {
        return worldRecordService.beatWorldRecord(id, command);
    }


    @DeleteMapping("/{id}")
    @Tag(name = "DELETE")
    @Operation(summary = "Deleting a world record", description = "This option is for deleting a world record by ID")
    @ApiResponse(responseCode = "204", description = "World record has been deleted")
    @ApiResponse(responseCode = "404", description = "World ecord not found")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWorldRecordById(@PathVariable("id") long id) {
        worldRecordService.deleteWorldRecordById(id);
    }
}
