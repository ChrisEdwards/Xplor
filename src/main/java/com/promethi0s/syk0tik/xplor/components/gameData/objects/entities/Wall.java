package com.promethi0s.syk0tik.xplor.components.gameData.objects.entities;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.Bounds;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class Wall extends Entity {

    public Wall(int x, int y, int scale) {

        super(x, y, scale, scale, true, false);

        sprite = Sprite.wall;

        this.bounds = new Bounds(x, y, sprite);

    }
}
