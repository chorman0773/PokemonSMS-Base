package github.chorman0773.pokemonsms.common.util.lua;

public interface BindableObject<D extends BindableObject<D>> {
	public abstract LuaDelegate<D> getDelegate();
}
