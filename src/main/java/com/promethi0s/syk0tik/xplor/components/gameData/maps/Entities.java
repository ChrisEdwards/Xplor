package com.promethi0s.syk0tik.xplor.components.gameData.maps;

import com.promethi0s.syk0tik.xplor.components.gameData.objects.Coordinates;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.MapObject;
import com.promethi0s.syk0tik.xplor.components.gameData.objects.entities.Entity;
import com.promethi0s.syk0tik.xplor.components.systems.Controls;

import java.util.ArrayList;

public class Entities extends Map {

    private Coordinates viewOffset;
    private Controls controls;

    public Entities(int width, int height, ArrayList<MapObject> entities, Coordinates viewOffset, Controls controls) {

        super(width, height, entities);

        this.viewOffset = viewOffset;
        this.controls = controls;

    }

    public void update() {

        for (int x = 0; x < objects.size(); x++) {

            MapObject object = objects.get(x);
            object.update();

        }

        for (int x = 0; x < objects.size(); x++) {

            MapObject object = objects.get(x);
            object.resetUpdateStatus();

        }

    }

    public Entity getEntityAt(int x, int y) {

        int pos = x + y * width;
        if (pos >= 0 && pos < objects.size()) {
            if (objects.get(pos) != null && objects.get(pos) != MapObject.empty) return (Entity) objects.get(pos);
        }
        return null;

    }

    public boolean move(Entity entity, Coordinates oldLoc, Coordinates newLoc) {

        int pos1 = oldLoc.x + oldLoc.y * width;
        int pos2 = newLoc.x + newLoc.y * width;

        if (pos2 >= 0 && pos2 < objects.size()) {
            objects.set(pos2, entity);
            objects.set(pos1, MapObject.empty);
            return true;
        }

        return false;

    }

    public void set(Entity entity, Coordinates loc) {

        if (loc.x + loc.y * width >= 0 && loc.x + loc.y * width < objects.size())
            objects.set(loc.x + loc.y * width, entity);

    }

    public void clear(Coordinates loc) {

        if (loc.x + loc.y * width >= 0 && loc.x + loc.y * width < objects.size())
            objects.set(loc.x + loc.y * width, MapObject.empty);

    }

}
