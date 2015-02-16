package com.promethi0s.syk0tik.xplor.components.gameData.objects.entities;

public class Cooldowns {

    public int fireball;

    public void update() {
        if (fireball > 0) fireball--;
    }

}
