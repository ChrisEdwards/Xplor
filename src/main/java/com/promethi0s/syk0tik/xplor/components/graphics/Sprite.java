package com.promethi0s.syk0tik.xplor.components.graphics;

public class Sprite {

    public static Sprite grass = new Sprite(0, 0, SpriteSheet.city);
    public static Sprite wall = new Sprite(1, 0, SpriteSheet.city);
    public static Sprite rock = new Sprite(2, 0, SpriteSheet.city);
    public static Sprite empty = new Sprite(3, 0, SpriteSheet.city);

    public static Sprite playerUp = new Sprite(0, 0, SpriteSheet.player);
    public static Sprite playerRight = new Sprite(1, 0, SpriteSheet.player);
    public static Sprite playerDown = new Sprite(2, 0, SpriteSheet.player);
    public static Sprite playerLeft = new Sprite(3, 0, SpriteSheet.player);

    public static Sprite testMobUp = new Sprite(0, 0, SpriteSheet.mobs);
    public static Sprite testMobRight = new Sprite(1, 0, SpriteSheet.mobs);
    public static Sprite testMobLeft = new Sprite(2, 0, SpriteSheet.mobs);
    public static Sprite testMobDown = new Sprite(3, 0, SpriteSheet.mobs);

    public static Sprite fireball = new Sprite(0, 0, SpriteSheet.projectiles);

    public int[] pixels;
    public int scale;
    // 254 R 254 G 254 B
    public int transparentColor = -65794;

    // Initializes a sprite with coordinates and home sheet (coordinates are not pixel-precision)
    public Sprite(int xLoc, int yLoc, SpriteSheet sheet) {

        this.scale = sheet.scale;

        pixels = new int[sheet.scale * sheet.scale];
        for (int x = 0; x < sheet.scale; x++) {
            for (int y = 0; y < sheet.scale; y++) {
                pixels[x + y * sheet.scale] = sheet.pixels[(x + xLoc * sheet.scale) + (y + yLoc * sheet.scale) * sheet.size];
            }
        }

    }
}
