package github.chorman0773.pokemonsms.common.pokemon;

import github.chorman0773.pokemonsms.common.util.IEventBus;
import github.chorman0773.pokemonsms.common.util.NullEventBus;
import github.chorman0773.pokemonsms.common.util.ResourceLocation;
import github.chorman0773.sentry.text.TextComponent;

import java.util.Set;

public class TypelessType extends Type {

    public static final TypelessType typeless = new TypelessType(ResourceLocation.valueOf("system","types/null"));

    static{
        Registries.Types.register(typeless);
    }

    public TypelessType(ResourceLocation name) {
        super(name, NullEventBus.getNullEventBus(), new TextComponent.Translation("types.system.types.typeless"), Set.of(), Set.of(), Set.of());
    }
}
