package github.chorman0773.pokemonsms.client;

import github.chorman0773.sentry.GameBasic;
import github.chorman0773.sentry.annotation.Game;
import github.chorman0773.sentry.generic.GenericGame;

@Game(gameId="pokemonsms",uuid="bedee0ae-3047-11eb-adc1-0242ac120002",version="1.0")
public class PokemonSMSGame extends GenericGame {


    protected PokemonSMSGame()  {
        super(60);
    }

    @Override
    protected void tick() {

    }
}
