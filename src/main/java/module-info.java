module github.chorman0773.pokemonsms.base {
	requires transitive github.chorman0773.pokemonsms.net;
	requires transitive luaj.jse;
	requires github.chorman0773.sentry.text;
	requires gson;
	requires jsr305;
	exports github.chorman0773.pokemonsms.common.util;
	exports github.chorman0773.pokemonsms.common.util.lua;
	exports github.chorman0773.pokemonsms.common.util.text;
	exports github.chorman0773.pokemonsms.common.system to github.chorman0773.pokemonsms.client, github.chorman0773.pokemonsms.server;
	exports github.chorman0773.pokemonsms.common.siding;
}