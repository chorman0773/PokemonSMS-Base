package github.chorman0773.pokemonsms.common.util;

public interface Events  {

    public interface Battle extends EventKey{
        public interface Ability extends Battle{
            public enum Lifetime implements Ability{
                Start,
                End,
                Reveal,
            }
            public enum LocalLifetime implements Ability{
                Start,
                End,
                Reveal,
            }
            public enum AbilityEvents implements Ability{

            }

        }
    }
}
