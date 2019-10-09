package github.chorman0773.pokemonsms.common.util;

public interface IEventBus {
	public void handleEvent(String event,Object...content);
}
