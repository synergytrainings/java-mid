package com.synisys.builder;

import com.synisys.builder.util.PlanetType;

/**
 * Created by arpine on 5/14/15.
 */
public class main {

	public static void  main(String[] args){



		SolarSystemPlanets mercuri = new SolarSystemPlanets.PlanetBuilder().name("Mercuri").createPlanet();
		SolarSystemPlanets jupiter = new SolarSystemPlanets.PlanetBuilder().name("Jupiter").planetType(PlanetType.JOVIAN).createPlanet();

		System.out.println(mercuri.toString());
		System.out.println(jupiter.toString());

	}
}
