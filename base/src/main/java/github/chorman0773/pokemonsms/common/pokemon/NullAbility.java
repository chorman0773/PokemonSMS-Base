package github.chorman0773.pokemonsms.common.pokemon;


import github.chorman0773.pokemonsms.common.util.NullEventBus;
import github.chorman0773.pokemonsms.common.util.ResourceLocation;
import github.chorman0773.sentry.text.TextComponent;

import java.util.Set;

public class NullAbility extends Ability {

    public static final NullAbility nullAbility = new NullAbility(ResourceLocation.valueOf("system","abilities/null"));

    public NullAbility(ResourceLocation name) {
        super(name, NullEventBus.getNullEventBus(), new TextComponent.Translation("ability.system.abilities.null"), Set.of());
    }
}
