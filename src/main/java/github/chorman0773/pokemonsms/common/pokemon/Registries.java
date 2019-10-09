package github.chorman0773.pokemonsms.common.pokemon;

import github.chorman0773.pokemonsms.common.util.Registry;
import github.chorman0773.pokemonsms.common.util.ResourceLocation;

public final class Registries {

    private Registries(){}

    public final static Registry<Type> Types = new Registry<>();

    static {
        registerSystemItems();
    }

    private static void registerSystemItems(){
        Types.register(new TypelessType(new ResourceLocation("system:types/typeless")));
    }

}
