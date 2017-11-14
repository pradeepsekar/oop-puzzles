package com.oop.puzzles.parkinglot.runner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.oop.puzzles.parkinglot.fileprocessor.ParkingLotFileProcessor;

public class ParkingLotAdministrator {
	private static String path = "./resources/parkinglot_inputs.txt";

	public static void main(String[] args) {
		Stream<String> fileStream = null;
		try {
			fileStream = Files.lines(Paths.get(path));
			List<String> fileContent = fileStream.filter(command -> !command.equals("")).collect(Collectors.toList());
			ParkingLotFileProcessor.processFileContents(fileContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fileStream.close();
		}

	}

}
