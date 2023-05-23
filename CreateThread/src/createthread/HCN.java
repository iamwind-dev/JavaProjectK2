/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package createthread;

import java.util.List;
    


public class HCN {
    private float length;
    private float width;
    public static void area(float length, float width, List<Float> result) {
        float area = length * width;
        result.add(area);
    }

    // Hàm tính chu vi hình chữ nhật
    public static void perimeter(float length, float width, List<Float> result) {
        float perimeter = 2 * (length + width);
        result.add(perimeter);
    }
}
