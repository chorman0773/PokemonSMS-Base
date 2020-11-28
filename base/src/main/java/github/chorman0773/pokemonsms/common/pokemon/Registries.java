package github.chorman0773.pokemonsms.common.pokemon;

import github.chorman0773.pokemonsms.common.util.Registry;
import github.chorman0773.pokemonsms.common.util.ResourceLocation;

public final class Registries {

    private Registries(){}

    public final static Registry<Registry<?>> Registries = new Registry<>(new ResourceLocation("internal:registries"));
    public final static Registry<Type> Types = new Registry<>(new ResourceLocation("internal:types"));
    public final static Registry<Move> Moves = new Registry<>(new ResourceLocation("internal:moves"));

    static {
        registerSystemItems();
    }

    private static void registerSystemItems(){
        Registries.register(Registries);
        Registries.register(Types);
        Registries.register(Moves);
        Types.register(new TypelessType(new ResourceLocation("system:types/typeless")));
        Moves.register(new NullMove(new ResourceLocation("system:moves/null")));
    }

}
