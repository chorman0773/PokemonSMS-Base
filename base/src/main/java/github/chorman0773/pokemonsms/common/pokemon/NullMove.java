package github.chorman0773.pokemonsms.common.pokemon;

import github.chorman0773.pokemonsms.common.util.NullEventBus;
import github.chorman0773.pokemonsms.common.util.ResourceLocation;
import github.chorman0773.sentry.text.TextComponent;

import java.util.Set;

public class NullMove extends Move {

    public static final NullMove null_move = new NullMove(ResourceLocation.valueOf("system","moves/null"));

    static{
        Registries.Moves.register(null_move);
    }

    public NullMove(ResourceLocation name) {
        super(name, NullEventBus.getNullEventBus(), new TextComponent.Translation("moves.system.moves.null"), ResourceLocation.valueOf("system:types/null"), MoveCategory.STATUS, Set.of(), 0, 1.0, 0);
    }
}
