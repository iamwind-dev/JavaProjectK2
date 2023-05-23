/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author WinD
 */
public class Chuvi implements Runnable{
    private float chieudai;
    private float chieurong;
    private float cv;

    public Chuvi(float chieudai, float chieurong) {
        this.chieudai = chieudai;
        this.chieurong = chieurong;
    }
    
    public float getCv() {
        return cv;
    }

    @Override
    public void run() {
        cv = (chieudai+chieurong)*2;
    }
    
}
