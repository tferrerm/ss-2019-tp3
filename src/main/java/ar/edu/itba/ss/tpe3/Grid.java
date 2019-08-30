package ar.edu.itba.ss.tpe3;

import java.util.Collections;
import java.util.List;

public final class Grid {

    private final List<Particle> particles;
    private final double areaBorderLength;

    public Grid(final List<Particle> particles) {
        this.areaBorderLength = Configuration.AREA_BORDER_LENGTH;
        this.particles = particles;
    }

    public void updateParticles(final double deltaTime) {
        for(Particle p : particles) {
            double newPositionX = p.getPosition().getX() + p.getVelocity().getX() * deltaTime;
            double newPositionY = p.getPosition().getY() + p.getVelocity().getY() * deltaTime;
            p.setPosition(newPositionX, newPositionY);
        }
    }

    public double getDensity() {
        return particles.size() / Math.pow(areaBorderLength, 2);
    }

    public List<Particle> getParticles() {
        return Collections.unmodifiableList(particles);
    }

    public double getAreaBorderLength() {
        return areaBorderLength;
    }

}
