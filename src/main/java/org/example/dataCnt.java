package org.example;

import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@CrossOrigin(origins = "*")
public class dataCnt {

    @PostMapping("/data")
    public String saveData(@RequestBody String data) throws IOException {
        try (FileWriter writer = new FileWriter("data.txt", true)) {
            writer.write(data + System.lineSeparator());
        }

        return "Данные сохранены";
    }

    @GetMapping("/data")
    public String getData() throws IOException {
        return Files.readString(Path.of("data.txt"));
    }
}