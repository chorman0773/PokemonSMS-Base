package github.chorman0773.pokemonsms.common.util;

public final class NullEventBus implements IEventBus {

	public NullEventBus() {
	}

	@Override
	public void handleEvent(String event, Object... content) {

	}

}
