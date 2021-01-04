package github.chorman0773.pokemonsms.common.pokemon;

import github.chorman0773.pokemonsms.common.util.RegistryObject;

import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalInt;

public class Pokemon {
    private RegistryObject<Species> species;
    private RegistryObject<Ability> ability;
    private int[] statIv;
    private int[] statEv;
    private ArrayList<Optional<MoveSlot>> moves;
    private int abilitySlot;
    private Optional<Boolean> gender;
    private int level;
    private int hp;
    private transient boolean statsDirty;
    private transient OptionalInt[] calculatedStats;
    private float pitchAdjust;
    private float volumeAdjust;
    private

    public static class MoveSlot {
        private final RegistryObject<Move> move;
        private int ppups;
        private int curPp;

        public MoveSlot(RegistryObject<Move> move) {
            this.move = move;
        }

        public Optional<Move> getMove(){
            return move.get();
        }

        public int getPPVal(){
            return curPp;
        }

        public int getMaxPp(){
            return move.get().stream().mapToInt(m->m.getMaxPP(ppups)).sum();
        }
    }

    public int getStatValue(Stat stat){
        if()
    }


}
