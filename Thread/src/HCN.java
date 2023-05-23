/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author WinD
 */
public class HCN {
    private float chieudai;
    private float chieurong;

    public HCN(float chieudai, float chieurong) {
        this.chieudai = chieudai;
        this.chieurong = chieurong;
    }

    HCN() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public float dientich(float chieudai,float chieurong){
        return chieudai*chieurong;
    }
    public float chuvi(float chieudai,float chieurong){
        return (chieudai+chieurong)*2;
    }
}
