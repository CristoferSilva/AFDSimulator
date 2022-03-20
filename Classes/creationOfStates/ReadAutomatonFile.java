package creationOfStates;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadAutomatonFile {
	private ArrayList<String> stateSetId;
	private ArrayList<String> alphabet;
	private ArrayList<String> transitionFunctions;
	private String initialStateId;
	private String finalStateId;

	public ReadAutomatonFile() {
		this.alphabet = new ArrayList<String>();
		this.stateSetId = new ArrayList<String>();
		this.transitionFunctions = new ArrayList<String>();
	}

	public void read(String address) throws FileNotFoundException {
		int courrentLine = 0;
		File file = new File(address);
		Scanner read = new Scanner(file);
		String[] auxArray;

		while (read.hasNext()) {
			if (courrentLine == 0) {
				auxArray = read.nextLine().split(" ");
				for (int i = 0; i < auxArray.length; i++) {
					this.stateSetId.add(auxArray[i]);
				}
				courrentLine++;
			} else if (courrentLine == 1) {
				auxArray = read.nextLine().split(" ");
				for (int i = 0; i < auxArray.length; i++) {
					this.alphabet.add(auxArray[i]);
				}
				courrentLine++;
			} else if (courrentLine >= 2) {
				this.transitionFunctions.add(read.nextLine());
				courrentLine++;
			}
		}

		this.finalStateId = transitionFunctions.remove(transitionFunctions.size() - 1);
		this.initialStateId = transitionFunctions.remove(transitionFunctions.size() - 1);
		
		read.close();
	}

	public ArrayList<String> getStateSetId() {
		return stateSetId;
	}

	public void setStateSetId(ArrayList<String> stateSet) {
		this.stateSetId = stateSet;
	}

	public ArrayList<String> getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(ArrayList<String> alphabet) {
		this.alphabet = alphabet;
	}

	public ArrayList<String> getTransitionFunctions() {
		return transitionFunctions;
	}

	public void setTransitionFunctions(ArrayList<String> transitionFunction) {
		this.transitionFunctions = transitionFunction;
	}

	public String getInitialStateId() {
		return initialStateId;
	}

	public void setInitialStateId(String initialState) {
		this.initialStateId = initialState;
	}

	public String getFinalStateId() {
		return finalStateId;
	}

	public void setFinalStateId(String finalState) {
		this.finalStateId = finalState;
	}
	
}
