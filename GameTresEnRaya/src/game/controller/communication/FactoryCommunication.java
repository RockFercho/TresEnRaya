/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.controller.communication;

/**
 *
 * @author Sergio Uriona
 */
public class FactoryCommunication {
    
    private static Communication communication = null;
    
    public static void createCommunication(int n) {
        switch (n) {
            case 1: communication = new PlayerCommunication(); break;
            case 2: communication = new ComputerCommunication(); break;
        }
    }
    
    public static Communication getCommunicator() {
        return communication;
    }
    
    public static void destroyCommunicator() {
        communication = null;
    }
}
