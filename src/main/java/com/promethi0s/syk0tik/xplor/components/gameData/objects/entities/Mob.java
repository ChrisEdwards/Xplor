package com.promethi0s.syk0tik.xplor.components.gameData.objects.entities;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.Entities;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.Coordinates;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

import static com.promethi0s.syk0tik.xplor.components.gameData.objects.entities.ProjectileFactory.Type.fireball;

// Adds shared move and attack behavior
public class Mob extends Entity {

    public Cooldowns cooldowns;

    public Mob(int x, int y, int faceDir, int width, int height, Entities entities, boolean isCollidable, boolean isAttackable) {

        super(x, y, width, height, isCollidable, isAttackable);
        this.entities = entities;
        this.faceDir = faceDir;

    }

    protected boolean moveUp() {

        Coordinates newLoc = new Coordinates(loc.x, loc.y - moveSpeed);
        faceDir = 0;
        entities.move(this, loc, newLoc);
        bounds.update(newLoc, faceDir);
        if (collidesWithSurroundings(newLoc)) {
            entities.move(this, newLoc, loc);
            bounds.update(loc, faceDir);
            return false;
        } else {
            loc = newLoc;
            return true;
        }

    }

    protected boolean moveRight() {

        Coordinates newLoc = new Coordinates(loc.x + moveSpeed, loc.y);
        faceDir = 1;
        entities.move(this, loc, newLoc);
        bounds.update(newLoc, faceDir);
        if (collidesWithSurroundings(newLoc)) {
            entities.move(this, newLoc, loc);
            bounds.update(loc, faceDir);
            return false;
        } else {
            loc = newLoc;
            return true;
        }

    }

    protected boolean moveDown() {

        Coordinates newLoc = new Coordinates(loc.x, loc.y + moveSpeed);
        faceDir = 2;
        entities.move(this, loc, newLoc);
        bounds.update(newLoc, faceDir);
        if (collidesWithSurroundings(newLoc)) {
            entities.move(this, newLoc, loc);
            bounds.update(loc, faceDir);
            return false;
        } else {
            loc = newLoc;
            return true;
        }

    }

    protected boolean moveLeft() {

        Coordinates newLoc = new Coordinates(loc.x - moveSpeed, loc.y);
        faceDir = 3;
        entities.move(this, loc, newLoc);
        bounds.update(newLoc, faceDir);
        if (collidesWithSurroundings(newLoc)) {
            entities.move(this, newLoc, loc);
            bounds.update(loc, faceDir);
            return false;
        } else {
            loc = newLoc;
            return true;
        }

    }

    protected boolean collidesWithSurroundings(Coordinates loc) {

        for (int x = loc.x - maxBounds; x <= loc.x + maxBounds; x++) {
            for (int y = loc.y - maxBounds; y <= loc.y + maxBounds; y++) {
                Entity target = entities.getEntityAt(x, y);
                if (!(loc.x == x && loc.y == y) && target != null) {
                    if (this.bounds.intersects(target.bounds)) {
                        if (target.isAttackable) attack(target);
                        if (target.isCollidable) return true;
                    }
                }
            }
        }
        return false;

    }

    // !Todo Replace entities.clear() with target.kill() to incorporate more complex death mechanics
    @Override
    protected void attack(Entity target) {

        if (target.faction == faction && faction != 0) return;

        target.takeDamage(attackPower);

    }

    @Override
    protected void takeDamage(int damage) {

        health -= damage;
        if (health < 1) destroy();

    }

    protected void fireballAttack() {

        if (cooldowns.fireball == 0) {
            ProjectileFactory.create(this, fireball);
            cooldowns.fireball = 60;
        }

    }

    public Sprite getSprite() {

        return sprites[faceDir];

    }

}