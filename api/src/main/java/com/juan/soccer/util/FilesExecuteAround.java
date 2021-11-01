package com.juan.soccer.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

// Execute-Around methods to avoid declaring Checked Exception
public interface FilesExecuteAround {
	// static polymorphism to overload single or list argument
	public static Stream<String> fileLines(List<String> path) {
		return path
			.parallelStream()
			.flatMap(FilesExecuteAround::fileLines);
	}

	public static Stream<String> fileLines(String path) {
		try {
			return Files.lines(Paths.get(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
