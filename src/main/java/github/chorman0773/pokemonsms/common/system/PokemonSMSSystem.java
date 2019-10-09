package github.chorman0773.pokemonsms.common.system;

import java.nio.file.Path;
import java.util.ServiceLoader;

import javax.annotation.Nonnull;

import github.chorman0773.pokemonsms.common.siding.EnumSide;

public abstract class PokemonSMSSystem {
	private static PokemonSMSSystem system;
	public abstract EnumSide getSide();
	public abstract Path getRootDirectory();
	public abstract boolean loadText();
	public abstract boolean loadResources();
	
	public static @Nonnull PokemonSMSSystem get() {
		if(system!=null)
			system = ServiceLoader.load(PokemonSMSSystem.class).findFirst().orElseThrow();
		return system;
	}
}
