package AFDSimulatorTests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;

import simulation.Simulation;

public class AFDSimulatorTests {

	@Test
	public void valid01ChainTest() throws IOException {
		FileWriter file = new FileWriter("d:\\automatonFile.txt");
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("q0 q1\n");
		writeFile.printf("0 1\n");
		writeFile.printf("q0 0 q1\n");
		writeFile.printf("q0 1 q0\n");
		writeFile.printf("q1 1 q1\n");
		writeFile.printf("q1 0 q0\n");
		writeFile.printf("q0\n");
		writeFile.printf("q0\n");

		file.close();

		Simulation simulation = new Simulation("d:\\automatonFile.txt", "111");
		assertEquals(true, simulation.isTheChainIsValid());

		File delete = new File("d:\\automatonFile.txt");
		delete.delete();

	}

	@Test
	public void valid02ChainTest() throws IOException {
		FileWriter file = new FileWriter("d:\\automatonFile.txt");
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("q0 q1\n");
		writeFile.printf("0 1\n");
		writeFile.printf("q0 0 q0\n");
		writeFile.printf("q0 1 q1\n");
		writeFile.printf("q1 0 q1\n");
		writeFile.printf("q1 1 q0\n");
		writeFile.printf("q0\n");
		writeFile.printf("q1\n");

		file.close();

		Simulation simulation = new Simulation("d:\\automatonFile.txt", "1000");
		assertEquals(true, simulation.isTheChainIsValid());

		File delete = new File("d:\\automatonFile.txt");
		delete.delete();

	}

	@Test
	public void invalid01ChainTest() throws IOException {
		FileWriter file = new FileWriter("d:\\automatonFile.txt");
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("q0 q1\n");
		writeFile.printf("0 1\n");
		writeFile.printf("q0 0 q1\n");
		writeFile.printf("q0 1 q0\n");
		writeFile.printf("q1 1 q1\n");
		writeFile.printf("q1 0 q0\n");
		writeFile.printf("q0\n");
		writeFile.printf("q0\n");

		file.close();

		Simulation simulation = new Simulation("d:\\automatonFile.txt", "01");
		assertEquals(false, simulation.isTheChainIsValid());

		File delete = new File("d:\\automatonFile.txt");
		delete.delete();

	}

	@Test
	public void invalid02ChainTest() throws IOException {
		FileWriter file = new FileWriter("d:\\automatonFile.txt");
		PrintWriter writeFile = new PrintWriter(file);

		writeFile.printf("q0 q1\n");
		writeFile.printf("0 1\n");
		writeFile.printf("q0 0 q0\n");
		writeFile.printf("q0 1 q1\n");
		writeFile.printf("q1 0 q1\n");
		writeFile.printf("q1 1 q0\n");
		writeFile.printf("q0\n");
		writeFile.printf("q1\n");

		file.close();

		Simulation simulation = new Simulation("d:\\automatonFile.txt", "011");
		assertEquals(false, simulation.isTheChainIsValid());

		File delete = new File("d:\\automatonFile.txt");
		delete.delete();

	}

}
