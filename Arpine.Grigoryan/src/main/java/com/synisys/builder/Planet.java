package com.synisys.builder;



/**
 * Created by arpine on 5/25/15.
 */
public class Planet {
	protected String name;
	protected double mass;
	protected double radius;

	public Planet(String name, double mass, double radius){
		this.name = name;
		this.radius = radius;
		this.mass = mass;
	}

	public String printDiameter(){
		// local inner class for planet Diameter
		class Diameter {
		    double diameter = 0;

			Diameter () {
				this.diameter=  Planet.this.radius * 2;
			}

			@Override
			public String toString() {
				return "Planet{ " + Planet.this.name +
						" diameter is " + diameter +
						'}';
			}
		}

		Diameter diameter = new Diameter();
		return diameter.toString();

	}

	// calculate surface gravity
	public  class Gravity {
		public double calculateSurfaceGravity(double g){
			return (g * Planet.this.mass) / Math.pow(Planet.this.radius, 2);
		}

	}

	static class Location{
		double x;
		double y;

		public Location(double x, double y){
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Location{ " +
					"x=" + x +
					", y=" + y +
					'}';

		}

	}

	public static Location calculateCurrentPlanetLocation (double currentX, double currentY) {

		// some logic  for calculating current location

		return new Location(currentX, currentY);

	}

	@Override
	public String toString() {
		return "Planet{" +
				"name= " + name +
				", mass= " + mass +
				", radius= " + radius +
				'}';

	}
}
