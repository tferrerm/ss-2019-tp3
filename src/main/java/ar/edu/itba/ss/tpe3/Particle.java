package ar.edu.itba.ss.tpe3;

import java.awt.geom.Point2D;
import java.util.Objects;

public class Particle implements Cloneable {
	
	private static int count = 0;
	
	private int id;
	private double radius;
	private double mass;
	private Point2D.Double position;
	private Point2D.Double velocity;
	
	public Particle(double radius, Point2D.Double position) {
		this.radius = radius;
		this.position = position;
	}
	
	public Particle(double radius, double mass) {
		this.id = count++;
		this.radius = radius;
		this.mass = mass;
		this.position = new Point2D.Double();
		this.velocity = new Point2D.Double();
	}
	
	public Particle(double radius, double mass, double x, double y, double vx, double vy) {
		this.id = count++;
		this.radius = radius;
		this.mass = mass;
		this.position = new Point2D.Double(x, y);
		this.velocity = new Point2D.Double(vx, vy);
	}
	
	private Particle(int id, double radius, double mass, double x, double y, double vx, double vy) {
		this.id = id;
		this.radius = radius;
		this.mass = mass;
		this.position = new Point2D.Double(x, y);
		this.velocity = new Point2D.Double(vx, vy);
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof Particle))
			return false;
		Particle other = (Particle) o;
		return this.id == other.getId();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public String toString() {
		return "id: " + id + "; radius: " + radius + " ; mass: " + mass + " ; x: " + position.x
				+ " ; y: " + position.y + " ; vx: " + velocity.x + " ; vy: " + velocity.y;
	}
	
	@Override
	public Particle clone() {
		return new Particle(id, radius, mass, position.getX(), position.getY(), velocity.getX(), velocity.getY());
	}

	public int getId() {
		return id;
	}

	public double getRadius() {
		return radius;
	}

	public double getMass() {
		return mass;
	}

	public Point2D.Double getPosition() {
		return position;
	}

	public void setPosition(double x, double y) {
		position.x = x;
		position.y = y;
	}

	public Point2D.Double getVelocity() {
		return velocity;
	}

	public void setVelocity(double vx, double vy) {
		velocity.x = vx;
		velocity.y = vy;
	}
	
	public double getVelocityAngle() {
		return Math.atan2(velocity.y, velocity.x);
	}

}