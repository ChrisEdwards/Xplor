package com.promethi0s.syk0tik.xplor.components.gameData.objects.entities;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.Entities;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.Bounds;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class Fireball extends Projectile {


    public Fireball(int x, int y, int faceDir, int width, int height, Entities entities) {

        super(x, y, faceDir, width, height, entities);

        sprites = new Sprite[4];
        sprites[0] = Sprite.fireball;
        sprites[1] = Sprite.fireball;
        sprites[2] = Sprite.fireball;
        sprites[3] = Sprite.fireball;

        this.bounds = new Bounds(x, y, sprites, faceDir);

        moveSpeed = 4;
        attackPower = 1;

    }


}
