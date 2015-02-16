package com.promethi0s.syk0tik.xplor.components.gameData.objects.entities;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.Bounds;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class Rock extends Entity {

    public Rock(int x, int y, int scale) {

        super(x, y, scale, scale, true, false);

        sprite = Sprite.rock;

        this.bounds = new Bounds(x, y, sprite);

    }

}
