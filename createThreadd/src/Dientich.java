/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author WinD
 */
public class Dientich implements Runnable{
    private float chieudai;
    private float chieurong;
    private float dt;

    public Dientich(float chieudai, float chieurong) {
        this.chieudai = chieudai;
        this.chieurong = chieurong;
    }
    
    public float getDt() {
        return dt;
    }
    
    @Override
    public void run() {
        dt=chieudai*chieurong;
    }

    
    
}
