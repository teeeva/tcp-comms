/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp.distributed;

import java.util.Random;

/**
 *
 * @author o
 */
    
    public class trafficGenerator{
       static Random randomNum = new Random();

       public static void main(String[] args){
          for(int i=0; i< 1; i++){
                System.out.println("Random number is : " + genRandom());
          }
       }

       public static int genRandom(){
          return randomNum.nextInt(3);
       }   
    }