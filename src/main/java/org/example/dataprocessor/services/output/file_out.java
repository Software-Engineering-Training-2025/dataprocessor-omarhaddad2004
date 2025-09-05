package org.example.dataprocessor.services.output;

import java.nio.file.Files;
import java.nio.file.Path;

public class file_out implements output_stratigy {
    @Override
    public void output(double value) throws Exception {
        Path p = Path.of("target", "result.txt");
        Files.createDirectories(p.getParent());
        Files.writeString(p, "Result = " + value);
    }
}
