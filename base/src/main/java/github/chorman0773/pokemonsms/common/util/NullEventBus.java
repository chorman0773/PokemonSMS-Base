package github.chorman0773.pokemonsms.common.util;

public final class NullEventBus implements IEventBus {
    private static final NullEventBus _null = new NullEventBus();

    public static IEventBus getNullEventBus(){
        return _null;
    }
	private NullEventBus() {
	}

	@Override
	public void handleEvent(EventKey event, Object... content) {

	}

}
