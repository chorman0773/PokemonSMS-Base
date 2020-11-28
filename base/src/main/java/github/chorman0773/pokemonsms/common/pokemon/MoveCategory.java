package github.chorman0773.pokemonsms.common.pokemon;

public enum MoveCategory {
	PHYSICAL(Stat.ATK,Stat.DEF),SPECIAL(Stat.SPEC,Stat.SPECDEF),STATUS(Stat.HP,Stat.HP);
	private final Stat atk;
	private final Stat def;
	MoveCategory(Stat atk,Stat def){
		this.atk = atk;
		this.def = def;
	}
	public Stat getAttackStat() {
		return atk;
	}
	public Stat getDefenseStat() {
		return def;
	}
	public boolean isCombatCategory() {
		return this!=STATUS;
	}
}
