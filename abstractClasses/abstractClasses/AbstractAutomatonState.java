package abstractClasses;

import deterministicFiniteAutomatonComposition.AutomatonState;
import deterministicFiniteAutomatonComposition.TransitionFunction;

public abstract class AbstractAutomatonState<Value> {
	private Value id;
	private TransitionFunction<Value> transition1;
	private TransitionFunction<Value> transition2;

	public AbstractAutomatonState(Value i) {
		this.id = i;
	}

	public AutomatonState<Value> executeTransition1() {
		return transition1.execute();
	}
	public AutomatonState<Value> executeTransition2() {
		return transition2.execute();
	}
	public Value getId() {
		return this.id;
	}
	public TransitionFunction<Value> getTransition2() {
		return transition2;
	}
	public TransitionFunction<Value> getTransition1() {
		return transition1;
	}

	public void setTransition1(String simbolo, AutomatonState<Value> nextState) {
		TransitionFunction<Value> transition = new TransitionFunction<Value>(simbolo, nextState);
		this.transition1 = transition;
	}
	public void setTransition2(String simbolo, AutomatonState<Value> nextState) {
		TransitionFunction<Value> transition = new TransitionFunction<Value>(simbolo, nextState);
		this.transition2 = transition;
	}
	public void setValue(Value value) {
		this.id = value;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AutomatonState<?>) {
			AutomatonState<?> nodeCompare = (AutomatonState<?>) obj;
			return nodeCompare.getId().equals(this.getId());
		}
		return false;
	}
}
