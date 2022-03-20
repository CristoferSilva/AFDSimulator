package creationOfStates;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import deterministicFiniteAutomatonComposition.AutomatonState;

public class States {
	private ArrayList<AutomatonState<String>> states;
	private AutomatonState<String> initialState, finalState;
	private ReadAutomatonFile file;

	public States(String path) {
		initializeFileAndStatesVariables();
		readFile(path);
		
		AutomatonState<String> courrentState;
		int amountStates = this.file.getStateSetId().size();
		int amountTransitionFunctions = this.file.getTransitionFunctions().size();

		for (int i = 0; i < amountStates; i++) {
			String courrentId = this.file.getStateSetId().get(i);
			courrentState = new AutomatonState<String>(courrentId);
			this.states.add(courrentState);
		}
		setTransitionInStates(amountTransitionFunctions);

		this.finalState = searchAutomatoState(this.file.getFinalStateId());
		this.initialState = searchAutomatoState(this.file.getInitialStateId());
	}

	private void initializeFileAndStatesVariables() {
		this.file = new ReadAutomatonFile();
		this.states = new ArrayList<AutomatonState<String>>();
	}

	private void setTransitionInStates(int amountTransitionFunctions) {
		AutomatonState<String> courrentState, nextCourrentState;
		String[] auxSplitTransitionFunction;
		String auxId, auxSimbol;

		for (int j = 0; j < amountTransitionFunctions; j++) {
			auxSplitTransitionFunction = this.file.getTransitionFunctions().get(j).split(" ");

			auxId = auxSplitTransitionFunction[0];
			auxSimbol = auxSplitTransitionFunction[1];
			nextCourrentState = searchAutomatoState(auxSplitTransitionFunction[2]);

			courrentState = searchAutomatoState(auxId);

			if (courrentState != null) {
				if (courrentState.getTransition1() == null) {
					courrentState.setTransition1(auxSimbol, nextCourrentState);
				} else {
					courrentState.setTransition2(auxSimbol, nextCourrentState);
				}
			}
		}
	}

	private void readFile(String path) {
		try {
			this.file.read(path);
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
	}

	private AutomatonState<String> searchAutomatoState(String wantedStateId) {
		int amountStates = this.file.getStateSetId().size();
		for (int i = 0; i < amountStates; i++) {
			if (wantedStateId.equals(this.states.get(i).getId())) {
				return this.states.get(i);
			}
		}
		return null;
	}

	public ArrayList<AutomatonState<String>> getStates() {
		return states;
	}

	public void setStates(ArrayList<AutomatonState<String>> states) {
		this.states = states;
	}

	public AutomatonState<String> getInitalState() {
		return initialState;
	}

	public void setInitalState(AutomatonState<String> headState) {
		this.initialState = headState;
	}

	public AutomatonState<String> getFinalState() {
		return finalState;
	}

	public void setFinalState(AutomatonState<String> finalState) {
		this.finalState = finalState;
	}

	public ReadAutomatonFile getFile() {
		return file;
	}

	public void setFile(ReadAutomatonFile file) {
		this.file = file;
	}

}
