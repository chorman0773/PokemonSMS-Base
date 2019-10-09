package github.chorman0773.pokemonsms.common.siding;

import github.chorman0773.pokemonsms.common.system.PokemonSMSSystem;

public enum EnumSide {
	CLIENT, SERVER;
	public static EnumSide side() {
		return PokemonSMSSystem.get().getSide();
	}
}
