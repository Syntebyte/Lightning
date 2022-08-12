package com.syntebyte.lightning.objects;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class Meteor {

    private UUID uuid;

    private Material material = Material.BEDROCK;
    private Sound falling = Sound.ENTITY_WITHER_AMBIENT;
    private Sound hit = Sound.ENTITY_WITHER_DEATH;
    private Sound hitLiquid = Sound.ENTITY_WITHER_SHOOT;
    private Sound burned = Sound.BLOCK_LAVA_EXTINGUISH;

    private Particle tail = Particle.SMOKE_LARGE;
    private Particle flames = Particle.FLAME;

    private int fallFlames = 50;
    private int hitFlames = 128;

    // Seconds before being burned in atmosphere
    private int lifetime = 10;

    private boolean flammable = true;

    // Fall speed. Blocks per second
    private int speed = 10;

    private boolean explosive = true;

    // Meteor weight in "kilos". Affects explosive power
    private int weight = 2;

    // Custom explosive power. -1 = speed*weight/4
    private int explosivePower = -1;

    /* Deals damage to LivingEntities depending on the
    distance of the collision point. -1 = speed * weight  */
    private int splashRadius = -1;
    private int splashMaxDamage = -1;

    // Always set LivingEntities on fire
    private boolean setEntitiesOnFire = true;

    // Meteor continues to move in the water or in the lava
    private boolean ignoreLiquids = true;

    // Checks all entities in a meteor chunk for collision
    private boolean hitEntityCheck = true;

    private Location startPos;
    private Location targetPos;

    private String postHitEvents = EventTypes.SET_BLOCK;
    private Material shardBlock = Material.OBSIDIAN;
    private ItemStack dropItem;
    private EntityType spawnEntity;
    private LightningBolt lightningBolt;

    private boolean invoked = false;
    private boolean paused = false;
    private int invokedC = 0;

    public static class EventTypes {

        public static final String NOTHING = "";
        public static final String SET_BLOCK = "b";
        public static final String DROP_ITEM = "i";
        public static final String SPAWN_ENTITY = "s";
        public static final String LIGHTNING_BOLT = "l";
    }

    public UUID getUUID() {
        return uuid;
    }

    public void setMaterial(Material meteorMaterial) {
        material = meteorMaterial;
    }

    public Material getMaterial() {
        return material;
    }

    public void setFallingSound(Sound fallingSound) {
        falling = fallingSound;
    }

    public void setHitSound(Sound hitSound) {
        hit = hitSound;
    }

    public void setHitLiquidSound(Sound hitLiquidSound) {
        hitLiquid = hitLiquidSound;
    }

    public void setBurnedSound(Sound burnedSound) {
        burned = burnedSound;
    }

    public void setTailParticle(Particle tailParticle) {
        tail = tailParticle;
    }

    public void setFlamesParticle(Particle flamesParticle) {
        flames = flamesParticle;
    }

    public void setFallFlamesCount(int fallFlamesCount) {
        fallFlames = fallFlamesCount;
    }

    public void setHitFlamesCount(int hitFlamesCount) {
        hitFlames = hitFlamesCount;
    }

    public void setLifetime(int lifetimeSec) {
        lifetime = lifetimeSec;
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setFlammable(boolean isFlammable) {
        flammable = isFlammable;
    }

    public boolean isFlammable() {
        return flammable;
    }

    public void setFallSpeed(int fallSpeed) {
        speed = fallSpeed;
    }

    public int getFallSpeed() {
        return speed;
    }

    public void setExplosive(boolean isExplosive) {
        explosive = isExplosive;
    }

    public boolean isExplosive() {
        return explosive;
    }

    public void setWeight(int meteorWeight) {
        weight = meteorWeight;
    }

    public int getWeight() {
        return weight;
    }

    public void setExplosivePower(int power) {
        explosivePower = power;
    }

    public int getExplosivePower() {
        return explosivePower;
    }

    public void setSplashRadius(int splash) {
        splashRadius = splash;
    }

    public int getSplashRadius() {
        return splashRadius;
    }

    public void setSplashMaxDamage(int maxDamage) {
        splashMaxDamage = maxDamage;
    }

    public int getSplashMaxDamage() {
        return splashMaxDamage;
    }

    public void setEntitiesOnFireInSplash(boolean setOnFire) {
        setEntitiesOnFire = setOnFire;
    }

    public boolean isEntitiesOnFireInSplash() {
        return setEntitiesOnFire;
    }

    public void setIgnoreLiquids(boolean isIgnoreLiquids) {
        ignoreLiquids = isIgnoreLiquids;
    }

    public boolean isIgnoreLiquids() {
        return ignoreLiquids;
    }

    public void setHitEntityCheck(boolean isHitEntityCheck) {
        hitEntityCheck = isHitEntityCheck;
    }

    public boolean isHitEntityCheck() {
        return hitEntityCheck;
    }

    public void setStartPos(Location start) {
        startPos = start;
    }

    public Location getStartPos() {
        return startPos;
    }

    public void setTargetPos(Location target) {
        targetPos = target;
    }

    public Location getTargetPos() {
        return targetPos;
    }

    public void setPostHitEvents(String postHitEv) {
        postHitEvents = postHitEv;
    }

    public String getPostHitEvents() {
        return postHitEvents;
    }

    public void setShardBlock(Material shard) {
        shardBlock = shard;
    }

    public Material getShardBlock() {
        return shardBlock;
    }

    public void setDropItem(ItemStack item) {
        dropItem = item;
    }

    public ItemStack getDropItem() {
        return dropItem;
    }

    public void setSpawnEntity(EntityType entityType) {
        spawnEntity = entityType;
    }

    public EntityType getSpawnEntity() {
        return spawnEntity;
    }

    public void setLightningBolt(LightningBolt lightning) {
        lightningBolt = lightning;
    }

    public LightningBolt getLightningBolt() {
        return lightningBolt;
    }

    public int getInvokedCount() {
        return invokedC;
    }

    // collisionRadius = 1;

    public Meteor(Location from, Location to) {

        uuid = UUID.randomUUID();
        startPos = from;
        targetPos = to;
    }

    public void invoke() {

        if(invoked) {
            return;
        }

        invoked = true;
        invokedC++;
    }

    public void pause() {

        paused = true;
    }

    public void resume() {

        paused = false;
    }

    public void remove() {
        // Removes meteor from world
        invoked = false;
    }

    public boolean wasInvoked() {
        return invoked;
    }

    public boolean wasPaused() {

        return paused;
    }

}