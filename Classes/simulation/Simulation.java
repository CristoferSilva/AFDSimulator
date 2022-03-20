package simulation;

import creationOfStates.States;
import deterministicFiniteAutomatonComposition.AutomatonState;

public class Simulation {
	private States states;
	private String chain;
	
	public Simulation(String path, String chain) {
		
		this.states =  new States(path);
		this.chain = chain;
	}
	
	public boolean isTheChainIsValid() {
		String courrentSimbol;
		AutomatonState<String> headState = this.states.getInitalState(), finalState = this.states.getFinalState();
		int inputStringLength = this.chain.length();

		for (int i = 0; i < inputStringLength; i++) {
			courrentSimbol = this.chain.charAt(i) + "";

			if (isTransition1(headState,courrentSimbol)) {
				headState = headState.executeTransition1();

			} else if (isTransition2(headState,courrentSimbol)) {
				headState = headState.executeTransition2();

			} else {
				return false;
			}
		}
		return headState.getId().equals(finalState.getId());
	}

	private boolean isTransition2(AutomatonState<String> headState, String courrentSimbol) {
		return courrentSimbol.equals(headState.getTransition2().getSimbolo());
	}

	private boolean isTransition1(AutomatonState<String> headState ,String courrentSimbol) {
		return courrentSimbol.equals(headState.getTransition1().getSimbolo());
	}

	public String getChain() {
		return chain;
	}
	public void setChain(String chain) {
		this.chain = chain;
	}
}
