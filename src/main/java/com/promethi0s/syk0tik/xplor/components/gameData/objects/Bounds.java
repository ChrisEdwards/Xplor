package com.promethi0s.syk0tik.xplor.components.gameData.objects;

import com.promethi0s.syk0tik.xplor.components.graphics.Sprite;

public class Bounds {

    public int x0, x1, y0, y1, x0Offset, x1Offset, y0Offset, y1Offset;
    private Bounds[] multBounds;

    public Bounds(int xLoc, int yLoc, Sprite sprite) {

        x0Offset = sprite.scale;
        x1Offset = 0;
        y0Offset = sprite.scale;
        y1Offset = 0;

        for (int y = 0; y < sprite.scale; y++) {
            for (int x = 0; x < sprite.scale; x++) {
                if (sprite.pixels[x + y * sprite.scale] != sprite.transparentColor) setLimits(x, y);
            }
        }

        update(new Coordinates(xLoc, yLoc));

    }

    // Called by objects with multiple sprites.
    public Bounds(int xLoc, int yLoc, Sprite[] sprites, int faceDir) {

        multBounds = new Bounds[sprites.length];
        for (int i = 0; i < sprites.length; i++) {
            multBounds[i] = new Bounds(xLoc, yLoc, sprites[i]);
        }

        update(new Coordinates(xLoc, yLoc), faceDir);

    }

    // Called by creation method. Tests to see if x or y are at limits and sets if applicable.
    private void setLimits(int x, int y) {

        if (x < x0Offset) x0Offset = x;
        if (x > x1Offset) x1Offset = x;
        if (y < y0Offset) y0Offset = y;
        if (y > y1Offset) y1Offset = y;

    }

    // Called on creation, and any time an entity's position is updated. Sets new bounds.
    public void update(Coordinates loc) {

        x0 = loc.x + x0Offset;
        x1 = loc.x + x1Offset;
        y0 = loc.y + y0Offset;
        y1 = loc.y + y1Offset;

    }

    // Called by objects with multiple sprites.
    public void update(Coordinates loc, int faceDir) {

        x0 = loc.x + multBounds[faceDir].x0Offset;
        x1 = loc.x + multBounds[faceDir].x1Offset;
        y0 = loc.y + multBounds[faceDir].y0Offset;
        y1 = loc.y + multBounds[faceDir].y1Offset;

    }

    public boolean intersects(Bounds target) {

        if (this.isIn(target) || target.isIn(this)) return true;
        return false;

    }

    private boolean isIn(Bounds target) {

        if ((x0 >= target.x0 && x0 <= target.x1 && y0 >= target.y0 && y0 <= target.y1) ||
                (x1 >= target.x0 && x1 <= target.x1 && y0 >= target.y0 && y0 <= target.y1) ||
                (x0 >= target.x0 && x0 <= target.x1 && y1 >= target.y0 && y1 <= target.y1) ||
                (x1 >= target.x0 && x1 <= target.x1 && y1 >= target.y0 && y1 <= target.y1)) return true;

        return false;

    }

}
