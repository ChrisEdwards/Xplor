package com.promethi0s.syk0tik.xplor.components.gameData.objects.entities;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.Entities;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.Bounds;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.Coordinates;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.MapObject;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class Entity extends MapObject {

    protected Entities entities;
    protected Coordinates loc;
    protected Bounds bounds;
    protected Sprite[] sprites;
    protected int maxBounds;
    protected boolean isCollidable;
    protected boolean isAttackable;
    protected boolean hasUpdated;

    protected int faceDir, width, height, faction, health, moveSpeed, attackPower;

    public Entity(int x, int y, int width, int height, boolean isCollidable, boolean isAttackable) {

        this.loc = new Coordinates(x, y);
        this.width = width;
        this.height = height;
        this.isCollidable = isCollidable;
        this.isAttackable = isAttackable;
        if (width > maxBounds) maxBounds = width;
        if (height > maxBounds) maxBounds = height;

    }

    @Override
    public void resetUpdateStatus() {
        hasUpdated = false;
    }


    // Does nothing unless overridden
    protected void attack(Entity target) {
    }

    protected void takeDamage(int damage) {
    }

    protected void destroy() {

        entities.clear(loc);

    }

}
