package abstractClasses;

import deterministicFiniteAutomatonComposition.AutomatonState;

public abstract class AbstractTransitionClass<Value> {
	private String simbolo;
	private AutomatonState<Value> nextState;
	
	public AbstractTransitionClass(String simbolo, AutomatonState<Value> nextState) {
		this.simbolo = simbolo;
		this.nextState = nextState;
	}
	public AutomatonState<Value> execute(){
		return nextState;
	}
	public String getSimbolo() {
		return simbolo;
	}
}
