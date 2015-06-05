package com.synisys.collections;

import com.synisys.builder.Planet;


/**
 * Created by arpine on 6/5/15.
 */
public class WeakMapEx {

	public static void main (String[] args) {

		String mercuryName = new String("Mercury");
		String planetName = "Mercury";

		Planet planetMercury = new Planet(planetName, 4.869E24,6051.8);

		PlanetStore store = new PlanetStore();

		store.addPlanet(planetName, planetMercury);
		store.addPlanet_W(mercuryName, planetMercury);

		mercuryName = null;

		int i = 1;
		while(i > 0 ) {
			if (store.getPlanets_W().size() != 0) {
				System.out.println("At iteration " + i + " the store still contain reference on " + planetName);
			} else {
				System.out.println("At iteration " + i + " gc remove weak reference on " + planetName);
				break;
			}
			i ++;
		}

	}
}
