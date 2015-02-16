package com.promethi0s.syk0tik.xplor.components.gameData.objects.entities;

import com.promethi0s.syk0tik.xplor.components.gameData.maps.Entities;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.Bounds;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.Coordinates;
import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;
import com.promethi0s.syk0tik.xplor.components.saveData.Settings;
import com.promethi0s.syk0tik.xplor.components.systems.Controls;

public class Player extends Mob {

    // !Todo Q for Chris: since I'd have to individually hand Map and Entities to each update method, is it better to keep them as attributes?

    private Coordinates viewOffset;
    private Settings settings;
    private Controls controls;

    public Player(int x, int y, int faceDir, int width, int height, Entities entities, Coordinates viewOffset, Settings settings, Controls controls) {

        super(x, y, faceDir, width, height, entities, true, true);
        this.viewOffset = viewOffset;
        this.settings = settings;
        this.controls = controls;
        cooldowns = new Cooldowns();

        moveSpeed = 1;
        health = 10;
        attackPower = 1;
        faction = 1;

        // !Todo Create sprites for diagonal movement and incorporate them
        sprites = new Sprite[4];
        sprites[0] = Sprite.playerUp;
        sprites[1] = Sprite.playerRight;
        sprites[2] = Sprite.playerDown;
        sprites[3] = Sprite.playerLeft;

        this.bounds = new Bounds(x, y, sprites, faceDir);

        updateCamera();

    }

    @Override
    public void update() {

        if (hasUpdated) return;

        if (controls.moveUp && !controls.moveDown) moveUp();
        if (controls.moveRight && !controls.moveLeft) moveRight();
        if (controls.moveDown && !controls.moveUp) moveDown();
        if (controls.moveLeft && !controls.moveRight) moveLeft();

        if (controls.viewUp && !controls.viewDown) faceDir = 0;
        if (controls.viewRight && !controls.viewLeft) faceDir = 1;
        if (controls.viewDown && !controls.viewUp) faceDir = 2;
        if (controls.viewLeft && !controls.viewRight) faceDir = 3;

        if (controls.attack) fireballAttack();

        updateCamera();

        cooldowns.update();

        hasUpdated = true;

    }


    public void updateCamera() {

        viewOffset.x = loc.x - settings.screenWidth / 2;
        viewOffset.y = loc.y - settings.screenHeight / 2;

    }

    @Override
    public Sprite getSprite() {

        return sprites[faceDir];

    }

}