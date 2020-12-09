package github.chorman0773.pokemonsms.common.pokemon;

import github.chorman0773.pokemonsms.common.util.Registry;
import github.chorman0773.pokemonsms.common.util.ResourceLocation;

public final class Registries {

    private Registries(){}

    public final static Registry<Registry<?>> Registries = new Registry<>(ResourceLocation.valueOf("internal:registries"));
    public final static Registry<Type> Types = new Registry<>(ResourceLocation.valueOf("internal:types"));
    public final static Registry<Move> Moves = new Registry<>(ResourceLocation.valueOf("internal:moves"));
    public static final Registry<Ability> Abilities = new Registry<>(ResourceLocation.valueOf("internal:abilities"));

    static {
        registerSystemItems();
    }

    private static void registerSystemItems(){
        Registries.register(Registries);
        Registries.register(Types);
        Registries.register(Moves);
        Registries.register(Abilities);
    }

}
