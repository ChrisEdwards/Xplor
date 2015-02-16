package com.promethi0s.syk0tik.xplor.components.gameData.objects.entities;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.Entities;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.Bounds;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

import java.util.Random;

public class TestMob extends Mob {

    private int updateCounter = 0;
    private Random random = new Random();

    public TestMob(int x, int y, int faceDir, int width, int height, Entities entities) {

        super(x, y, faceDir, width, height, entities, true, true);

        moveSpeed = 1;
        health = 1;
        attackPower = 1;
        faction = 2;

        sprites = new Sprite[4];
        sprites[0] = Sprite.testMobUp;
        sprites[1] = Sprite.testMobRight;
        sprites[2] = Sprite.testMobDown;
        sprites[3] = Sprite.testMobLeft;

        this.bounds = new Bounds(x, y, sprites, faceDir);

    }

    @Override
    public void update() {

        if (hasUpdated) return;

        if (updateCounter == 0) faceDir = random.nextInt(4);

        if (faceDir == 0) moveUp();
        if (faceDir == 1) moveRight();
        if (faceDir == 2) moveDown();
        if (faceDir == 3) moveLeft();

        updateCounter++;
        hasUpdated = true;

        if (updateCounter == 20) updateCounter = 0;

    }

}
