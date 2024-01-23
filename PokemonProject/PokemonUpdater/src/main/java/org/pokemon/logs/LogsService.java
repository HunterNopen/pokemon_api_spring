package org.pokemon.logs;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogsService {
    public List<String> getAllLogs(){
        Path path = Paths.get("D:\\git\\PokemonProject\\logsUpdater.log");
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
