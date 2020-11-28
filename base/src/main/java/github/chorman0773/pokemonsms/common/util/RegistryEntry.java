package github.chorman0773.pokemonsms.common.util;

public interface RegistryEntry<E extends RegistryEntry<E>> {
	public ResourceLocation getName();
	public Class<E> getRegistryType();
}
