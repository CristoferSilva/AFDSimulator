package deterministicFiniteAutomatonComposition;

import abstractClasses.AbstractTransitionClass;

public class TransitionFunction<Value> extends AbstractTransitionClass<Value> {

	public TransitionFunction(String simbolo, AutomatonState<Value> nextState) {
		super(simbolo, nextState);
	}
	
}

