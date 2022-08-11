package com.syntebyte.lightning.objects;

import org.bukkit.Location;
import org.bukkit.Particle;

import java.util.UUID;

public class LightningBolt {

    private final UUID uuid;
    private boolean ignoreBlocksAbove = false;
    private Location destination;
    private boolean explosive = false;
    private boolean flammable = true;
    private int flames = 100;
    private float explosionPower = 2;
    private int invoked = 0;

    public LightningBolt(Location target) {

        uuid = UUID.randomUUID();
        destination = target;
    }

    public void invoke() {

        Location target = ignoreBlocksAbove ?
            destination :
            destination.getWorld().getHighestBlockAt(destination).getLocation();
            // .add(0, 1, 0)

        if(flammable) {
            target.getWorld().strikeLightning(target);
        } else {
            target.getWorld().strikeLightningEffect(target);
        }

        target.getWorld().spawnParticle(Particle.FLAME, target, flames);
        if(explosive) {
            target.getWorld().createExplosion(target, explosionPower, flammable);
        }

        invoked++;
    }

    public UUID getUUID() {
        return uuid;
    }

    public boolean isIgnoreBlocksAbove() {
        return ignoreBlocksAbove;
    }

    public Location getDestination() {
        return destination;
    }

    public boolean isExplosive() {
        return explosive;
    }

    public boolean isFlammable() {
        return flammable;
    }

    public int getFlamesCount() {
        return flames;
    }

    public float getExplosionPower() {
        return explosionPower;
    }

    public int getInvokedCount() {
        return invoked;
    }

    public void setIgnoreBlocksAbove(boolean isIgnoreBlocksAbove) {
        ignoreBlocksAbove = isIgnoreBlocksAbove;
    }

    public void setDestination(Location strikeDestination) {
        destination = strikeDestination;
    }

    public void setExplosive(boolean isExplosive) {
        explosive = isExplosive;
    }

    public void setFlammable(boolean isFlammable) {
        flammable = isFlammable;
    }

    public void setFlamesCount(int flamesCount) {
        flames = flamesCount;
    }

    public void setExplosionPower(float power) {
        explosionPower = power;
    }
}
