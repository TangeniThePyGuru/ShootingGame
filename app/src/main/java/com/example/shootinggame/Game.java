package com.example.shootinggame;

import java.util.Random;

public class Game
{
    private double birdX;
    private double birdY;
    private double birdSpeed;

    private double bulletX;
    private double bulletY;
    private double bulletSpeed;
    private double bulletAngle;

    private double gunX;
    private double gunY;

    private double radius;
    private double distanceThreshold;

    private boolean fired;
    private boolean hit;

    public Game()
    {
        initializeGame();
    }

    public void update()
    {
        moveBird();

        if (fired)
            moveBullet();

        if (sceneClear())
            initializeGame();
    }

    public void fire()
    {
        fired = true;
    }

    public double getBirdX()
    {
        return birdX;
    }

    public double getBirdY()
    {
        return birdY;
    }

    public double getBulletX()
    {
        return bulletX;
    }

    public double getBulletY()
    {
        return bulletY;
    }

    public double getGunX()
    {
        return gunX;
    }

    public double getGunY()
    {
        return gunY;
    }

    public double getRadius()
    {
        return radius;
    }

    private void moveBird()
    {
        if (!hit)
        {
            birdX = birdX - birdSpeed;
            hit = decideHit();
        }
        else
            birdY = birdY - birdSpeed;
    }

    private void moveBullet()
    {
        bulletX = bulletX + bulletSpeed*Math.cos(bulletAngle*Math.PI/180);
        bulletY = bulletY + bulletSpeed*Math.sin(bulletAngle*Math.PI/180);
    }

    private boolean decideHit()
    {
        double distance = Math.sqrt((birdX - bulletX)*(birdX - bulletX) +
                (birdY - bulletY)*(birdY - bulletY));

        return distance <= distanceThreshold;
    }

    private boolean sceneClear()
    {
        return (birdX < 0 || birdY < 0) && bulletY > 1000;
    }

    private int random_number(int lowerBound, int upperBound){
        Random rand = new Random();
        return rand.nextInt(upperBound) + lowerBound;
    }

    private void initializeGame()
    {
//        double sceneWidth = 480;
        double sceneHeight = 680;
        double gunLength = 100;
        double gunAngle = 45 + 30 * Math.random();

        this.birdX = sceneHeight - 50;
        this.birdY = (double) random_number(150, 250);
        this.birdSpeed = 10;

        this.gunX = gunLength*Math.cos(gunAngle*Math.PI/180);
        this.gunY = gunLength*Math.sin(gunAngle*Math.PI/180);

        this.bulletX = gunX;
        this.bulletY = gunY;
        this.bulletSpeed = 20;
        this.bulletAngle = gunAngle;

        this.radius = 50;
        this.distanceThreshold = 100;

        this.fired = false;
        this.hit = false;
    }
}

